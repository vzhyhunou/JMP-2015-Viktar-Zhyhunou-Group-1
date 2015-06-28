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

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    private static final long serialVersionUID = -8352863755612742747L;

    @EJB
    private UserServiceBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                         throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
                          throws ServletException, IOException {
        User user = new User();
        user.setLogin(request.getParameter("login"));
        userBean.addUser(user);
        request.getSession().setAttribute("authorized_user", user);
        response.sendRedirect(request.getContextPath()+"/");
    }
}
