package com.codeup.adlister.dao;


import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {


            stmt = connection.prepareStatement("SELECT * FROM ads WHERE status!=0");

            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description,category,status) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setString(4,ad.getCategory());
            stmt.setInt(5,ad.getStatus());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public Long edit(String id, String title, String description, String category, int status) {
        return null;
    }


    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getString("category"),
            rs.getInt("status")

        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }





    @Override
   public void deactivateAd(int ide){
        String query="UPDATE ads SET status=? WHERE id=?";
        try{
            PreparedStatement stmt=connection.prepareStatement(query);
            stmt.setInt(1,0);
            stmt.setInt(2,ide);
            int set=stmt.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Ad> userAdds(int id) {
        PreparedStatement stmt;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE status=1 AND user_id=?");
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    public List<Ad> GetAdById(String id){
        String query = "SELECT * FROM ads WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, id);
           ResultSet rs =stmt.executeQuery();
           List<Ad> output =  createAdsFromResults(rs);
           return output;

        } catch (SQLException e) {
            throw new RuntimeException("Error finding a ad by id", e);
        }

    }


    public List<Ad> search(String searchItem) throws SQLException {
        String input = "SELECT * FROM ads WHERE title LIKE ? OR description LIKE ? OR category LIKE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(input);
            stmt.setString(1, "%" + searchItem + "%");
            stmt.setString(2, "%" + searchItem + "%");
            stmt.setString(3, "%" + searchItem + "%");
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error with search results", e);
        }
    }

    @Override
    public void edit(String id, String title, String description) {

    }


    @Override
    public void edit(String id, String title, String description, String category) {

        try {

            String insertQuery = " UPDATE ads SET title = ?, description = ?, category = ? where id= ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setString(3,category);
            stmt.setString(4, id);

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }

    }


    public void addImage(){



    }


}
