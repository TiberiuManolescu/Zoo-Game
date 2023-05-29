package com.zoogame.entities;

import com.zoogame.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDb {
    //String connectionURL =  "jdbc://localhost/zoo-game";
    String connectionURL = "jdbc:mysql://localhost:3306/zoo-game";
    String username = "admin";
    String password = "36^Q/3%{8YwpBMK&";


    public User getUser(int user_id) throws SQLException {
        User user = null;

        try (Connection conn = DriverManager.getConnection(connectionURL, username, password)) {
            String sql = "SELECT * FROM users WHERE id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, user_id);
            ResultSet result = statement.executeQuery();



            if (result.next()) {
                user = new User();
                user.setUser_id(result.getInt("user_id"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
            }
        }

        return user;
    }

    public User getUserByUsername(String searchedUsername) throws SQLException {
        User user = null;

        try (Connection conn = DriverManager.getConnection(connectionURL, username, password)) {
            String sql = "SELECT * FROM users WHERE username=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, searchedUsername);
            ResultSet result = statement.executeQuery();


            if (result.next()) {
                user = new User();
                user.setUser_id(result.getInt("user_id"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
            }
        }

        return user;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(connectionURL, username, password)) {
            String sql = "SELECT * FROM users";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                User user = new User();
                user.setUser_id(result.getInt("user_id"));
                user.setUsername(result.getString("username"));
                user.setPassword(result.getString("password"));
                users.add(user);
            }
        }

        return users;
    }

    public String insertUser(User user) throws SQLException {
        String message = null;

        try (Connection conn = DriverManager.getConnection(connectionURL, username, password)) {
            // Check if the username already exists
            PreparedStatement checkStatement = conn.prepareStatement("SELECT * FROM users WHERE username=?");
            checkStatement.setString(1, user.getUsername());
            ResultSet resultSet = checkStatement.executeQuery();


            if (resultSet.next()) {
                message = "Username already exists";

            } else { // Aici cream utilizatorul
                // Insert the new user
                PreparedStatement insertStatement = conn.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
                insertStatement.setString(1, user.getUsername());
                insertStatement.setString(2, user.getPassword());
                insertStatement.executeUpdate();
                message = "User inserted successfully";
            }
        }

        return message;
    }

    public boolean checkUserExists(String username) throws SQLException {
        try (Connection conn = DriverManager.getConnection(connectionURL, this.username, this.password)) {
            String sql = "SELECT * FROM users WHERE username=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet result = statement.executeQuery();
            return result.next();
        }
    }
    public boolean loginUser(User user) throws SQLException {
        try (Connection conn = DriverManager.getConnection(connectionURL, this.username, this.password)) {
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            ResultSet result = statement.executeQuery();
            return result.next();
        }
    }
}