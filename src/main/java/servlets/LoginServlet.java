package servlets;

import com.todolist.dao.UserDao;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by askol on 6/16/2017.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws
            ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        User user = null;
        boolean error = false;
        String errorMsg = null;

        String login = httpServletRequest.getParameter("login");
        String password = httpServletRequest.getParameter("password");

        if (login == null || password == null
                || login.length() == 0 || password.length() == 0) {
            error = true;
            errorMsg = "Required username and password!";
        } else {
            user = UserDao.INSTANCE.getUserByLoginAndPassword(login, password);

            if (user == null) {
                error = true;
                errorMsg = "User name or password is not correct";
            }
        }
        if (error) {
            user = new User();
            user.setName(login);
            user.setPassword(password);

            httpServletRequest.setAttribute("errorString", errorMsg);
            httpServletRequest.setAttribute("user", user);

            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(httpServletRequest, httpServletResponse);
        } else {
            HttpSession session = httpServletRequest.getSession();
            LoggedUser.saveLoggedUser(session, user);
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/userPage");
            PrintWriter out = httpServletResponse.getWriter();
            out.println("Welcome" + login);
        }
    }
}
