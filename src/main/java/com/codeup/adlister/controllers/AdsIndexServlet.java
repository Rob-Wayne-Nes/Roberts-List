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

//        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        List<Ad> ads = DaoFactory.getAdsDao().all();
        for(Ad ad: ads){
            String title = ad.getTitle();
            if(title.length() > 10){
                String titletrim = title.substring(0,10);
                ad.setTitle(titletrim);
            }
            if(ad.getDescription().length() > 30){
                String descript = ad.getDescription();
                String descriptiontrim = descript.substring( 0, 30);
                ad.setDescription(descriptiontrim);
            }

        }

        request.setAttribute("ads", ads);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
