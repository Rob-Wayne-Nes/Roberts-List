package com.codeup.adlister.controllers;

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

//        String userId = null;
//        int isAdmin;

        String adId = request.getParameter("id");
        Ad thisAd = DaoFactory.getAdsDao().GetAdById(adId).get(0);
        String clase="none";
        String display="none";
        //checking for an open session
        if(request.getSession().getAttribute("user")!=null) {
            User user = (User) request.getSession().getAttribute("user");
            int isAdmin = user.getRole();//is admin?
            String adUserId = Long.toString(thisAd.getUserId());
            String userId = Long.toString(user.getId());
            request.setAttribute("name", user.getUsername());
            //****this is where to put the wiring for the users
            if (adUserId.equals(userId)) {
                clase = "";
            }
            //****this is where to put the wiring for the admin
            if (isAdmin == 1) {
                clase = "";
                display = "block";
            }

        }

        request.setAttribute("display",display);
        request.setAttribute("clase",clase);
        request.setAttribute("ad", thisAd);
        request.getRequestDispatcher("/WEB-INF/ads/page.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String id =request.getParameter("id");

        int intid = Integer.parseInt(id);

        String edit = request.getParameter("edit");
        String delete = request.getParameter("delete");
        String ban = request.getParameter("ban");



        List<Ad> ad = DaoFactory.getAdsDao().GetAdById(id);
        String adUserId = Long.toString(ad.get(0).getUserId());

        System.out.println("pre ban userid" + adUserId);
        System.out.println("Ad recibida "+ ad.get(0).getTitle());


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