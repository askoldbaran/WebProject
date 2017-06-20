package servlets;

import com.todolist.dao.ItemDao;
import entity.Item;
import entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by askol on 6/19/2017.
 */
@WebServlet("/addItem")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        User user;
        Item item;
        boolean error = false;
        String text = httpServletRequest.getParameter("text");
        HttpSession session = httpServletRequest.getSession();
        user = (User) session.getAttribute("loggedUser");

        item = new Item(text);
        ItemDao.INSTANCE.saveItem(user, item);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/userPage");
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        doGet(httpServletRequest,httpServletResponse);
    }
}
