package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //The stuff for the navbar

        HttpSession session = request.getSession();
        String uname = (String) session.getAttribute("user");
        String location = "ads";

        if (uname != null) {
            boolean loggedin = true;
            request.setAttribute("loggedin", loggedin);
        } else {
            boolean loggedin = false;
            request.setAttribute("loggedin", loggedin);
        }
        request.setAttribute("location", location);

        //**********************
        
        String searchItem = request.getParameter("input");

        request.setAttribute("searchTerm", searchItem);
        String message = "";

        try {
            if (DaoFactory.getAdsDao().search(searchItem).isEmpty()) {
                message = "No results found.";
                request.setAttribute("message", message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            request.setAttribute("ads", DaoFactory.getAdsDao().search(searchItem));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

}
