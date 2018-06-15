package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);


    void deactivateUser(String intid);

    void editUser(String username, String email, String password, long id);

    void editUserNotPW(String username, String email, long id);
}
