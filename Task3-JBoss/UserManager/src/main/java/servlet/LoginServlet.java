package servlet;

import model.User;
import service.UserServiceBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 6761684123369764203L;

    @EJB
    UserServiceBean userServiceBean;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        User loggedUser = userServiceBean.findUserByLogin(login);
        req.getSession().setAttribute("authorized_user", loggedUser);

        resp.sendRedirect("home");
    }
}
