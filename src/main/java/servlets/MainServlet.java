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
 * Created by askol on 6/14/2017.
 */
@WebServlet(urlPatterns = {"/","/home"})
public class MainServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

//        final User user = UserDao.INSTANCE.getUserById(1);
//        response.setContentType("text/html");
//        PrintWriter writer = response.getWriter();
//        writer.println("<html>");
//        writer.println("<head>");
//        writer.println("<title>Sample Application Servlet Page </title>");
//        writer.println("</head>");
//        writer.println("<body bgcolor=white>");
//
//        writer.println("<table border=\"0\" cellpadding=\"10\">");
//        writer.println("<tr>");
//        writer.println("<td>");
//        writer.println("<img src=\"images/springsource.png\">");
//        writer.println("</td>");
//        writer.println("<td>");
//        writer.println("<h1>Sample Application Servlet"+user+"</h1>");
//        writer.println("</td>");
//        writer.println("</tr>");
//        writer.println("</table>");
//
//        writer.println("This is the output of a servlet that is part of");
//        writer.println("the Hello, World application.");
//
//        writer.println("</body>");
//        writer.println("</html>");


    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }
}
