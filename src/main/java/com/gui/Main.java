package com.gui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application{

    @Override
    public void start(Stage stage)throws Exception{
        Font.loadFont(getClass().getResourceAsStream("/font/PressStart2P-Regular.ttf"), 14);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/main-menu.fxml"));

        Scene scene = new Scene(loader.load(), 1280, 720);


        stage.setTitle("Mini Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}