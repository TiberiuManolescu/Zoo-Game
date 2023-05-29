package com.zoogame.views;

import com.zoogame.controllers.GameController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.zoogame.models.User;

import java.io.IOException;

public class ViewManager {
    /*private Stage primaryStage;

    // Constructor
    public ViewManager(Stage ps) {
        this.primaryStage = ps;

        try {
            showRegisterView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ViewManager() {
    }

    public void showRegisterView() throws IOException {
        loadView("/fxml/register.fxml", null);
    }

    public void showGameViewWithData(User user) throws IOException {
        loadView("/fxml/game.fxml", user);
    }

    private void loadView(String fxmlPath, User user) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());

        // Pass userData to the controller
        if (user != null) {
            GameController controller = loader.getController();
            controller.setUser(user);
        }

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // Getters
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    // Setters
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }*/
    private static Stage primaryStage; // Change to static

    public static void setPrimaryStage(Stage stage) { // Add a setter method
        primaryStage = stage;

        try {
            showRegisterView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showRegisterView() throws IOException {
        loadView("/fxml/register.fxml", null);
    }

    public static void showGameViewWithData(User userData) throws IOException {
        loadView("/fxml/game.fxml", userData);
    }

    private static void loadView(String fxmlPath, User userData) throws IOException {
        FXMLLoader loader = new FXMLLoader(ViewManager.class.getResource(fxmlPath));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(ViewManager.class.getResource("/css/style.css").toExternalForm());

        // Pass userData to the controller
        if (userData != null) {
            GameController controller = loader.getController();
            controller.setUser(userData);
        }

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
