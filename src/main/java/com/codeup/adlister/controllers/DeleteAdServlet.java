package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteAdServlet",urlPatterns = "/delete")
public class DeleteAdServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response){
        String deleteById= request.getParameter("deleteById");
        DaoFactory.getAdsDao().deactivateAd(Integer.parseInt(deleteById));
        request.setAttribute("ads", DaoFactory.getAdsDao().all());
        try {
            request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
            response.sendRedirect("/ads");
        }catch (Exception e){
            throw new RuntimeException(e);
        }


    }

}
