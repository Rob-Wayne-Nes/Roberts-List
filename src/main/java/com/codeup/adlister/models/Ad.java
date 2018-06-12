package com.codeup.adlister.models;

public class Ad {
    private long id;
    private long userId;
    private String title;
    private String description;
    private String category;
    private int status;

    public Ad(long id, long userId, String title, String description, String category, int status) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.category= category;
        this.status = 1;
    }

    public Ad(long userId, String title, String description,String category,int status) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.category=category;
        this.status = 1;
    }


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void editAd(String id){

    }
}
