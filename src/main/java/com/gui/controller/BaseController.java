package com.gui.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Node;

public abstract class BaseController {
    protected void switchScene(ActionEvent event, String fxmlPath) throws Exception{
        Parent newRoot = FXMLLoader.load(getClass().getResource(fxmlPath));

        Scene scene = new Scene(newRoot, 1280, 720);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
