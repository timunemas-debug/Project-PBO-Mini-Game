package com.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class LobbyController extends BaseController{

    @FXML
    private StackPane rootlobby;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnExit;
    @FXML
    private ImageView bgimagelobby;

    @FXML
    public void initialize(){
        System.out.println("INITIALIZE LOBBY DI CALL");
        var streamlobby = getClass().getResourceAsStream("/Images/bgdisplaylobby.png");

        if(streamlobby == null){
            System.out.println("Gambar lobby tidak ditemukan");
            return;
        }

        Image bg = new Image(streamlobby);
        bgimagelobby.setImage(bg);
        javafx.application.Platform.runLater(() -> {
            bgimagelobby.fitWidthProperty().bind(rootlobby.widthProperty());
            bgimagelobby.fitHeightProperty().bind(rootlobby.heightProperty());
            System.out.println("background berhasil di set");
        });

    }

    @FXML
    private void handlePlayGame(ActionEvent event)throws Exception{
        switchScene(event, "/fxml/pertempuran.fxml");
    }
    
    @FXML
    private void handleProfile(ActionEvent event)throws Exception{
        switchScene(event, "/fxml/profile.fxml");
    }

    @FXML
    private void handleInventory(ActionEvent event)throws Exception{
        switchScene(event, "/fxml/inventory.fxml");
    }

    @FXML
    private void exitGame(){
        System.exit(0);
    }
}
