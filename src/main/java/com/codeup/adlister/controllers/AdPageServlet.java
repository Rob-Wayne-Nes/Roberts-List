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

        request.setAttribute("adId", adId);
        request.getRequestDispatcher("/WEB-INF/ads/page.jsp").forward(request, response);


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String id = request.getParameter("id");

        int intid = Integer.parseInt(id);

        String edit = request.getParameter("edit");
        System.out.println(edit);
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
            }

            if (ban != null && ban.equals("1")) {
                DaoFactory.getUsersDao().deactivateUser(adUserId);
            }
//        }
    }
}
