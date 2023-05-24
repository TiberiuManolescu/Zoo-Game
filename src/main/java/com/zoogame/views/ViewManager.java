package com.zoogame.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewManager {
    private Stage primaryStage;

    // Constructor
    public ViewManager(Stage ps) {
        this.primaryStage = ps;

        try {
            showRegisterView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRegisterView() throws IOException {
        loadView("/fxml/register.fxml");
    }

    public void showLoginView() throws IOException {
        loadView("/fxml/login.fxml");
    }

    private void loadView(String fxmlPath) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/css/style.css").toExternalForm());
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
    }
}
