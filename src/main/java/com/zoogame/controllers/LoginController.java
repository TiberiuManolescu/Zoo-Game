package com.zoogame.controllers;

import com.zoogame.entities.UserDb;
import com.zoogame.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    private void handleSubmitButtonAction() throws SQLException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Check if username and password are at least 3 characters long
        if (username.length() < 3 || password.length() < 3) {
            // Show an error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Username and password must be at least 3 characters long");
            alert.showAndWait();
            return;
        }

        // Try to authenticate the user
        UserDb userDb = new UserDb();
        User user = new User(username, password);

        boolean loginSuccessful = userDb.loginUser(user);
        if (loginSuccessful) {
            // Login successful, show a success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Login Successful");
            alert.setHeaderText(null);
            alert.setContentText("User " + username + " logged in successfully");
            alert.showAndWait();
        } else {
            // Login failed, show an error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText("Incorrect username or password");
            alert.showAndWait();
        }
    }
}
