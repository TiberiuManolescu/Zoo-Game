package com.zoogame;

import com.zoogame.entities.UserDb;
import com.zoogame.models.User;
import com.zoogame.views.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a new instance of the ViewManager
        ViewManager.setPrimaryStage(primaryStage);

        // Set the title of the primary stage
        primaryStage.setTitle("Zoo Game");

        // Show the primary stage
        primaryStage.show();

    }

    public static void main(String[] args) throws SQLException {
        // Launch the application
        launch(args);
    }
}