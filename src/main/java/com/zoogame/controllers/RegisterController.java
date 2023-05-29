package com.zoogame.controllers;

import com.zoogame.entities.UserDb;
import com.zoogame.views.ViewManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import com.zoogame.models.User;
import com.zoogame.utils.MessageAlert;

import java.io.IOException;
import java.sql.SQLException;

public class RegisterController {
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button registerButton;

    @FXML
    private Button loginButton;

    @FXML
    public void initialize() {
    }

    @FXML
    private void handleRegisterButtonAction() throws SQLException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.length() < 3 || password.length() < 3) {
            MessageAlert.showAlert("Field Length Error", "The fields length is too small.");
            return; // Exit the method if fields are too small
        }

        User newUser = new User(username, password);
        UserDb userDb = new UserDb();
        String response = userDb.insertUser(newUser);

        if (response.equals("Username already exists")) {
            MessageAlert.showAlert("Username duplicate", "This username already exists. Please try another one.");
        } else if (response.equals("User inserted successfully")) { // Username doesn't exist
            MessageAlert.showAlert("Registration success!", "User inserted successfully!");
        }

        this.usernameField.clear();
        this.passwordField.clear();
    }

    public void handleLoginButtonAction(ActionEvent actionEvent) throws SQLException, IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.length() < 3 || password.length() < 3) {
            MessageAlert.showAlert("Field Length Error", "The fields length is too small.");
            return; // Exit the method if fields are too small
        }

        User user = new User(username, password);
        UserDb userDb = new UserDb();
        Boolean response = userDb.loginUser(user);

        if (response == false) {
            MessageAlert.showAlert("Login error", "Username or password incorrect. Please try again.");
        }
        else
        {
            // Username & password are OK
            MessageAlert.showAlert("Login success!", "You will be logged in in short time.");

            ViewManager.showGameViewWithData(user);
        }

        this.usernameField.clear();
        this.passwordField.clear();
    }
}
