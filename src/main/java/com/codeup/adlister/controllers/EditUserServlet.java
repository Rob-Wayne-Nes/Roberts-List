package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "controllers.EditUserServlet", urlPatterns = "/profile/edit")
public class EditUserServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //The stuff for the navbar

        HttpSession session = request.getSession();
        Object uname = session.getAttribute("user");
        String location = "edit";

        if (uname != null) {
            boolean loggedin = true;
            request.setAttribute("loggedin", loggedin);
        } else {
            boolean loggedin = false;
            request.setAttribute("loggedin", loggedin);
        }
        request.setAttribute("location", location);

        //**********************

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return ;
        } else {
            User este = (User) request.getSession().getAttribute("user");
            request.setAttribute("ads", DaoFactory.getAdsDao().userAdds((int) este.getId()));
            request.getRequestDispatcher("/WEB-INF/EditUser.jsp").forward(request, response);

        }




    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (password.isEmpty()){
             User user = (User) request.getSession().getAttribute("user");
             password = user.getPassword();
        }

        System.out.println(password);
        DaoFactory.getUsersDao().editUser(username, email, password, id);

        request.getSession().removeAttribute("user");
        request.getSession().invalidate();

        response.sendRedirect("/login");

    }
}