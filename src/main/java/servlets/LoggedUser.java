package servlets;

import entity.User;

import javax.servlet.http.HttpSession;

/**
 * Created by askol on 6/18/2017.
 */
public class LoggedUser {
    public static void saveLoggedUser(HttpSession session, User loggedUser) {
        session.setAttribute("loggedUser", loggedUser);
    }

    public static User getLoggedUser(HttpSession session) {
        return (User) session.getAttribute("loggedUser");
    }

    public static void signOutUser(HttpSession session) {
        if (session == null || getLoggedUser(session) == null) {
            return;
        }
        session.removeAttribute("loggedUser");
    }
}
