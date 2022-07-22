package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;
    private PreparedStatement statement;

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
        try {
            String sql = "SELECT * FROM ads";
            statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            return createAdsFromResults(rs);

        }catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            statement = connection.prepareStatement("INSERT INTO ads (user_id,title,description) VALUES (?, ? , ?)", Statement.RETURN_GENERATED_KEYS);
            statement.executeUpdate();

            statement.setLong(1,ad.getUserId());
            statement.setString(2, ad.getTitle());
            statement.setString(3, ad.getDescription());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys()


            ResultSet rs = statement.getGeneratedKeys();
            rs.next();

            return rs.getLong(1);

        }catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private String createInsertQuery(Ad ad) {
//        return "INSERT INTO ads(user_id, title, description) VALUES "
//            + "(" + ad.getUserId() + ", "
//            + "'" + ad.getTitle() +"', "
//            + "'" + ad.getDescription() + "')";
        return "INSERT INTO ads(user_id,title,description) VALUES (?,?,?)";
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }



}
