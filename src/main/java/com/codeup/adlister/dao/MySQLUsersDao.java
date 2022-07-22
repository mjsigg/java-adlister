package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users{
    private static Connection connection;

    public MySQLUsersDao(Config config) throws SQLException {
        if (connection == null) {
            try {
                DriverManager.registerDriver(new Driver ());
                connection= DriverManager.getConnection(
                        config.getUrl(),
                        config.getUser(),
                        config.getPassword()
                );
            }catch (SQLException e) {
                throw new RuntimeException("whatever",e);
            }
        }
    }

    @Override
    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,username);
            ResultSet rs = statement.executeQuery();
            rs.next();

            return new User(
                    rs.getLong("id",
                            rs.getString("username"),
                            rs.getString("email"),
                            rs.getString("password"))
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long insert(User user) {
        String sql = "INSERT INTO users (username, email, password) VALUES (? , ? , ?)";
        PreparedStatement statement;

        try{
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1,user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();

            return rs.getLong(1);

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
