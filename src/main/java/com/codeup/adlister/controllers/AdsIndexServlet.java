package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.DatagramPacket;
import java.util.List;

@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //The stuff for the navbar

        HttpSession session = request.getSession();
        Object uname = session.getAttribute("user");
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

        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        List<Ad> ads = DaoFactory.getAdsDao().all();
        for(Ad ad: ads){
            String title = ad.getTitle();
            if(title.length() > 8){
                String titletrim = title.substring(0,8);
                ad.setTitle(titletrim);
            }
            if(ad.getDescription().length() > 10){
                String descript = ad.getDescription();
                String descriptiontrim = descript.substring( 0, 10);
                ad.setDescription(descriptiontrim);
            }
            if(ad.getCategory().length() > 10){
                String cat = ad.getCategory();
                String catTrim = cat.substring(0,10);
                ad.setCategory(catTrim);
            }

        }

        request.setAttribute("ads", ads);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
