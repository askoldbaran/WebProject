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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by askol on 6/18/2017.
 */
@WebServlet("/userPage")
public class UserPageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        doGet(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        HttpSession session = httpServletRequest.getSession();
        User loggedUser = LoggedUser.getLoggedUser(session);

        httpServletRequest.setAttribute("user", loggedUser);

        List<Item> list = ItemDao.INSTANCE.itemsByUserId(loggedUser.getUserID());

        httpServletRequest.setAttribute("itemList", list);
        RequestDispatcher dispatcher = httpServletRequest.getRequestDispatcher("/userPage.jsp");
        dispatcher.forward(httpServletRequest, httpServletResponse);
    }
}

