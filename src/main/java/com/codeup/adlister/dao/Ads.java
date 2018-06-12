package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    //change the status of an Ad;
     void deactivateAd(int id);
//     /return ads created by a specific user by userId
    List<Ad> userAdds(int id);
}
