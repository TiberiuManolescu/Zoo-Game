package com.zoogame.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.zoogame.models.User;

public class GameController {
    private User user;

    @FXML
    private Label scoreLabel;

    private int score;

    @FXML
    private void handleStartGame() {
        score = 0;
        updateScoreLabel();
    }

    @FXML
    private void handleAnimalClick() {
        score += 10;
        updateScoreLabel();
    }

    private void updateScoreLabel() {
        scoreLabel.setText("Score: " + score);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

