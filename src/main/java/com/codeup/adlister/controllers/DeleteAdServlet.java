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
//        DaoFactory.getAdsDao()


    }


}
