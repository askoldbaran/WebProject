package servlets;

import com.todolist.dao.UserDao;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by askol on 6/15/2017.
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String login = httpServletRequest.getParameter("email");
        String password = httpServletRequest.getParameter("psw");
        String name = httpServletRequest.getParameter("name");
        int age = Integer.parseInt(httpServletRequest.getParameter("age"));
        String address = httpServletRequest.getParameter("address");

        String errorMsg = null;
        if (login == null || password == null || name == null || age <= 0 || address == null) {
            errorMsg = "Wrong input";
        }
        if (errorMsg != null) {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/singup.jsp");
            PrintWriter out = httpServletResponse.getWriter();
            out.println("<font color=red>" + errorMsg + "</font>");
            rd.include(httpServletRequest, httpServletResponse);
        } else {
            User user = new User(name, age, login, password, address);
            UserDao.INSTANCE.saveUser(user);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        doGet(httpServletRequest, httpServletResponse);
    }
}
