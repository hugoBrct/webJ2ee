package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

public class LoginController extends HttpServlet {

    private HashMap<String, String> users;

    public LoginController(){
        users = new HashMap<String, String>();
        users.put("admin", "admin");
        users.put("lambda", "lambda");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        if(users.containsKey(login)){
            String val = users.get(login);
            if(val.equals("admin")){
                session.setAttribute("user", login);
                resp.sendRedirect(req.getContextPath() + "/restreint/adminPage.jsp");
            }else{
                session.setAttribute("user", login);
                resp.sendRedirect(req.getContextPath() + "/restreint/lambdaPage.jsp");
            }
        }else{
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
