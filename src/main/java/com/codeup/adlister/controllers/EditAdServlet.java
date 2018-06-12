package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "controllers.EditAdServlet", urlPatterns = "/ads/edit")
public class EditAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String adId = request.getParameter("id");
        System.out.println("edit servlet" + adId);
        List<Ad> ad = DaoFactory.getAdsDao().GetAdById(adId);
        String adUserId = Long.toString(ad.get(0).getUserId());
        String title = ad.get(0).getTitle();
        String description = ad.get(0).getDescription();


        request.setAttribute("adId", adId);
        request.setAttribute("title", title);
        request.setAttribute("adUserId", adUserId);
        request.setAttribute("description", description);




        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);


    }
}
