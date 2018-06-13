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



//
//@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
//public class AdsIndexServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        request.setAttribute("ads", DaoFactory.getAdsDao().all());
//        List<Ad> ads = DaoFactory.getAdsDao().all();
//        for(Ad ad: ads){
//            String title = ad.getTitle();
//            if(title.length() > 10){
//                String titletrim = title.substring(0,10);
//                ad.setTitle(titletrim);
//            }
//            if(ad.getDescription().length() > 30){
//                String descript = ad.getDescription();
//                String descriptiontrim = descript.substring( 0, 30);
//                ad.setDescription(descriptiontrim);
//            }
//
//        }
//
//        request.setAttribute("ads", ads);
//        request.getRequestDispatcher("index.jsp").forward(request, response);
//    }
//}



@WebServlet(name = "controllers.AdPageServlet", urlPatterns = "/ads/page")
public class AdPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        String userId = null;
        int isAdmin;
        String adId = request.getParameter("id");
        Ads ads = DaoFactory.getAdsDao();
        List<Ad> ad = DaoFactory.getAdsDao().GetAdById(adId);
        String adUserId = Long.toString(ad.get(0).getUserId());

        if (user != null){
            userId = Long.toString(user.getId());
            isAdmin = user.getRole();

        } else {
            userId = null;
            isAdmin = 0;
        }

        if (user != null && userId.equals(adUserId)) {
            //****this is where to put the wiring for the users
        }

        if (user != null && isAdmin == 1){
            //****this is where to put the wiring for the admin
        }

        request.getRequestDispatcher("/WEB-INF/ads/page.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String edit = request.getParameter("edit");
        String delete = request.getParameter("delete");
        String ban = request.getParameter("ban");

        if (edit.equals("1")){
            //where to wire up the edit button
        }
        if (delete.equals("1")){
            //where to wire up the delete button
        }
        if (ban.equals("1")){
            //where to wire up the ban button
        }
    }
}
