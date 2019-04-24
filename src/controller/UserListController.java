package controller;

import beans.User;
import dao.UserDao;

import javax.jws.soap.SOAPBinding;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class UserListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("On rentre dans userlist controller");
        RequestDispatcher rd = req.getRequestDispatcher("/restreint/user/listingUser.jsp");

        // On recup tous les users
        UserDao userManager = new UserDao();
        ArrayList<User> listUser = userManager.findAll();

        System.out.println("Taille liste : " + listUser.size());

        for(User u : listUser){
            System.out.println(u.getEmail());
        }

        req.setAttribute("listUser", listUser);
        rd.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
