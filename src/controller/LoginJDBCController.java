package controller;

import beans.User;
import dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginJDBCController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User user1 = (User)session.getAttribute("user");
        if(user1 != null){
            // On recupere l'utilisateur a partir de l'email
            UserDao userManager = new UserDao();
            if(user1.getRole().equals("admin")){
                req.setAttribute("user", user1);
                resp.sendRedirect(req.getContextPath() + "/restreint/adminPageJDBC.jsp");
            }else {
                req.setAttribute("user", user1);
                resp.sendRedirect(req.getContextPath() + "/restreint/lambdaPageJDBC.jsp");
            }
        }else {
            resp.sendRedirect(req.getContextPath() + "/loginDatabase.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        // On recupere l'utilisateur a partir de l'email
        UserDao userManager = new UserDao();
        User user = userManager.findByMail(email);

        if(user != null) {
            // Si le user existe on ajoute en session
            if (password.equals(user.getPassword())) {
                session.setAttribute("user", user);
            }
        }

        resp.sendRedirect(req.getContextPath() + "/loginDatabase");
    }

}
