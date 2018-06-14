package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //the iputs from the JSP need to link up with the parameters in the insert method
       String id = request.getParameter("adId");
       String category = request.getParameter("category");
       String title = request.getParameter("title");
        String description = request.getParameter("description");



        DaoFactory.getAdsDao().edit(id, title, description, category);

        response.sendRedirect("/ads");

    }
}
