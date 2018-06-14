package com.codeup.adlister.controllers;

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

@WebServlet(name = "DeleteAdServlet",urlPatterns = "/delete")
public class DeleteAdServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return ;
        } else {


            User este = (User) request.getSession().getAttribute("user");
            String deleteById = request.getParameter("deleteById");
            System.out.println("this is the id " + deleteById);
            DaoFactory.getAdsDao().deactivateAd(Integer.parseInt(deleteById));


            List<Ad> ads = DaoFactory.getAdsDao().userAdds((int) este.getId());
            for (Ad ad : ads) {
                String title = ad.getTitle();
                if (ad.getTitle().length() > 8) {
                    String titrim = title.substring(0, 8);
                    ad.setTitle(titrim);
                }
                if (ad.getDescription().length() > 20) {
                    String desc = ad.getDescription();
                    String descTrim = desc.substring(0, 20);
                    ad.setDescription(descTrim);

                }
                if (ad.getCategory().length() > 10) {
                    String cat = ad.getCategory();
                    String catTrim = cat.substring(0, 10);
                    ad.setCategory(catTrim);
                }
            }

            request.setAttribute("ads", ads);
            try {
                request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
                response.sendRedirect("/profile");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }


}
