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
import javax.servlet.http.HttpSession;
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



        User user = (User) request.getSession().getAttribute("user");


        String userId = null;
        int isAdmin;
        String adId = request.getParameter("id");
//        Ads ads = DaoFactory.getAdsDao();
        List<Ad> ad = DaoFactory.getAdsDao().GetAdById(adId);
        String adUserId = Long.toString(ad.get(0).getUserId());

        if (user != null){
            userId = Long.toString(user.getId());
            isAdmin = user.getRole();
            request.setAttribute("name", user.getUsername());

        } else {
            userId = null;
            isAdmin = 0;
        }

        if (user != null && userId.equals(adUserId)) {
            //****this is where to put the wiring for the users
            request.setAttribute("title", ad.get(0).getTitle());
        }



        if (user != null && isAdmin == 1){
            //****this is where to put the wiring for the admin
        }

        request.setAttribute("adId", adId);
        request.getRequestDispatcher("/WEB-INF/ads/page.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String id = request.getParameter("id");

        int intid = Integer.parseInt(id);

        String edit = request.getParameter("edit");
        String delete = request.getParameter("delete");
        String ban = request.getParameter("ban");


        List<Ad> ad = DaoFactory.getAdsDao().GetAdById(id);
        String adUserId = Long.toString(ad.get(0).getUserId());

//        if (edit != null || delete != null || ban != null) {

            if (edit != null && edit.equals("1")) {
                response.sendRedirect("/ads/edit?id=" + id);
                return;
            }
            if (delete != null && delete.equals("1")) {
                DaoFactory.getAdsDao().deactivateAd(intid);
                response.sendRedirect("/ads");
                return;
            }

            if (ban != null && ban.equals("1")) {
                DaoFactory.getUsersDao().deactivateUser(adUserId);
                response.sendRedirect("/ads");
                return;
            }
//        }
    }
}
