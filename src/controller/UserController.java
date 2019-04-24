package controller;

import beans.User;
import dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getRequestURL().toString();
        String[] url = action.split("/");
        action = url[url.length-1];
        switch (action) {
            case "list":
                this.listerUser(req, resp);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void listerUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/restreint/user/listingUser.jsp");

        System.out.println("on rentre la");

        // On recup tous les users
        UserDao userManager = new UserDao();
        ArrayList<User> listUser = userManager.findAll();

        req.setAttribute("listUser", listUser);
        rd.forward(req, resp);
    }
}
