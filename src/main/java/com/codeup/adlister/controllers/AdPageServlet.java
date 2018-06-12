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

        try {
            userId = Long.toString(user.getId());
        } catch (NullPointerException e){
             userId = null;
        }

        String adId = request.getParameter("id");
         Ads ads = DaoFactory.getAdsDao();

        List<Ad> ad =DaoFactory.getAdsDao().GetAdById(adId);
           String adUserId = Long.toString(ad.get(0).getUserId());


           if (!userId.equals(null) && userId.equals(adUserId)){
               System.out.println("this worked");
           }



//        if ()

      //call to the ad dao and see if the user id on the ad equals the user id on the user
      //if it does give them the option to edit or delete.



    }
//        if (request.getSession().getAttribute("user") == null) {
//            response.sendRedirect("/login");
//            return;
//        }
//        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
//                .forward(request, response);
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");
        Ad ad = new Ad(
                user.getId(),
                request.getParameter("title"),
                request.getParameter("description"),
                request.getParameter("category")
        );
        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/ads");
    }
}