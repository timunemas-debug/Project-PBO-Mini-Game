package com.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private void startGame(ActionEvent event) throws Exception {

        Parent root = FXMLLoader.load(
                getClass().getResource("/fxml/game.fxml")
        );

        Scene scene = new Scene(root, 1280,720);
        Stage stage = (Stage)((Node)event.getSource())
                .getScene()
                .getWindow();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    private void exitGame() {
        System.exit(0);
    }
}