package com.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class MemilihCharacterController extends BaseController{
    
    @FXML
    private StackPane rootmemilihcharacter;
    @FXML
    private Button btnMemilihDraven;
    @FXML
    private Button btnMemilihLyra;
    @FXML
    private Button btnMemilihKaelion;
    @FXML
    private ImageView bgImageMemilihCharacter;

    @FXML
    public void initialize(){
        System.out.println("INITIALIZE CHOOSE CHARACTER");
        var streamchoose = getClass().getResourceAsStream("/Images/bgdisplaychoose.png");

        if(streamchoose == null){
            System.out.println("gambar tidak ditemukan");
            return;
        }

        Image bg = new Image(streamchoose);
        bgImageMemilihCharacter.setImage(bg);

        bgImageMemilihCharacter.fitWidthProperty().bind(rootmemilihcharacter.widthProperty());
        bgImageMemilihCharacter.fitHeightProperty().bind(rootmemilihcharacter.heightProperty());

        System.out.println("Background berhasil di set");

        btnMemilihDraven.getStyleClass().clear();
        btnMemilihDraven.getStyleClass().add("btnMemilihDraven");

        btnMemilihKaelion.getStyleClass().clear();
        btnMemilihKaelion.getStyleClass().add("btnMemilihKaelion");

        btnMemilihLyra.getStyleClass().clear();
        btnMemilihLyra.getStyleClass().add("btnMemilihLyra");

    }

    @FXML
    private void handlePlayerDraven(ActionEvent event)throws Exception{
        switchScene(event, "/fxml/lobby.fxml");
    }

    @FXML
    private void handlePlayerLyra(ActionEvent event)throws Exception{
        switchScene(event, "/fxml/lobby.fxml");
    }

    @FXML
    private void handlePlayerKaelion(ActionEvent event)throws Exception{
        switchScene(event, "/fxml/lobby.fxml");
    }
}