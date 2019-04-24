package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class CookieController extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("AffichageCookie.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String value = req.getParameter("value");
        Cookie c = new Cookie(name, value);
        resp.addCookie(c);
        RequestDispatcher rd = req.getRequestDispatcher("AffichageCookie.jsp");
        resp.sendRedirect(req.getContextPath() + "/form");
    }
}
