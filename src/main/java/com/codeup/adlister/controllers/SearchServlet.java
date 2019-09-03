package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

            List<Ad> ads = DaoFactory.getAdsDao().search(searchItem);
            for (Ad ad: ads){
                String title = ad.getTitle();
                if (title.length() > 8){
                    String titTrim = title.substring(0,8);
                    ad.setTitle(titTrim);
                }
                if (ad.getDescription().length() > 20){
                    String desc = ad.getDescription();
                    String descTrim = desc.substring(0,20);
                    ad.setDescription(descTrim);

                }
                if(ad.getCategory().length() > 10){
                    String cat = ad.getCategory();
                    String catTrim = cat.substring(0,10);
                    ad.setCategory(catTrim);
                }
            }

            request.setAttribute("ads", ads);




        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

}
