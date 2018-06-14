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

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //The stuff for the navbar

        HttpSession session = request.getSession();
        Object uname = session.getAttribute("user");
        String location = "profile";

        if (uname != null) {
            boolean loggedin = true;
            request.setAttribute("loggedin", loggedin);
        } else {
            boolean loggedin = false;
            request.setAttribute("loggedin", loggedin);
        }
        request.setAttribute("location", location);

        //**********************

        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return ;
        } else {


            User este = (User) request.getSession().getAttribute("user");
            List<Ad> ads = DaoFactory.getAdsDao().userAdds((int) este.getId());
            for (Ad ad : ads){
                String title = ad.getTitle();
                if(title.length() > 8){
                    String titletrim = title.substring(0,8);
                    ad.setTitle(titletrim);
                }
                if(ad.getDescription().length() > 12){
                    String des = ad.getDescription();
                    String destrim = des.substring(0, 12);
                    ad.setDescription(destrim);
                }
                if(ad.getCategory().length() > 10){
                    String cat = ad.getCategory();
                    String catTrim = cat.substring(0,10);
                    ad.setCategory(catTrim);
                }
            }


            request.setAttribute("ads", ads);
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
        }
    }
}



