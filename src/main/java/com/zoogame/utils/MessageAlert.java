package com.zoogame.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MessageAlert {
    public static void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
