package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "SearchServlet",urlPatterns = "/search")
public class SearchSevlet  extends HttpServlet{
     @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {
        String searchTerm= req.getParameter("input");
        System.out.println(searchTerm);
        req.setAttribute("ads",DaoFactory.getAdsDao().GetAdBySearch(searchTerm));
        try {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            resp.sendRedirect("/ads");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
