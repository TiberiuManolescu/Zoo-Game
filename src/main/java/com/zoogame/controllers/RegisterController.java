package com.zoogame.controllers;

import com.zoogame.entities.UserDb;
import com.zoogame.models.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import java.sql.SQLException;

public class RegisterController {

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
            alert.setTitle("Registration Error");
            alert.setHeaderText("Username and password must be at least 3 characters long");
            alert.showAndWait();
            return;
        }

        // Try to register the user
        UserDb userDb = new UserDb();
        User newUser = new User(username, password);

        String message = userDb.insertUser(newUser);
        if (message == null) {
            // Registration successful, show a success message
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registration Successful");
            alert.setHeaderText(null);
            alert.setContentText("User " + username + " registered successfully");
            alert.showAndWait();
        } else {
            // Registration failed, show an error message
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Registration Error");
            alert.setHeaderText(message);
            alert.showAndWait();
        }
    }
}
