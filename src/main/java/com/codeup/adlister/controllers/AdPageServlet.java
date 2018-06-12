package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Ads;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.AdPageServlet", urlPatterns = "/ads/page")
public class AdPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String userId = null;
        int isAdmin;

        try {
            userId = Long.toString(user.getId());
        } catch (NullPointerException e) {
            userId = null;
        }
        isAdmin = user.getRole();

        System.out.println(isAdmin);

        String adId = request.getParameter("id");
        Ads ads = DaoFactory.getAdsDao();

        List<Ad> ad = DaoFactory.getAdsDao().GetAdById(adId);
        String adUserId = Long.toString(ad.get(0).getUserId());


        if (!userId.equals(null) && userId.equals(adUserId)) {
            System.out.println("this worked");


        }
        if (isAdmin == 1){
            System.out.println("is admin");
        }
    }
}
