package com.gui;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage stage){
        Label label = new Label("Hello java");

        StackPane root = new StackPane(label);
        Scene scene = new Scene(root, 900, 450);

        stage.setTitle("Myfirst");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
