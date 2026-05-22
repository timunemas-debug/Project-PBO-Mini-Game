package com.gui.controller;

import com.gui.model.CharacterMiniGame.Draven;
import com.gui.model.CharacterMiniGame.Kaelion;
import com.gui.model.CharacterMiniGame.Lyra;
import com.gui.service.ChooseCharacter;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

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

    private Draven draven = new Draven("Draven", 85, 30, 0, false, 85);
    private Lyra lyra = new Lyra("Lyra", 90, 25, 0, 0, false, 90);
    private Kaelion kaelion = new Kaelion("Kaelion", 110, 20, 0, 0, false, 110);

    @FXML
    public void initialize(){
        btnMemilihDraven.setCursor(Cursor.HAND);
        btnMemilihLyra.setCursor(Cursor.HAND);
        btnMemilihKaelion.setCursor(Cursor.HAND);

        System.out.println("INITIALIZE CHOOSE CHARACTER");
        var streamchoose = getClass().getResourceAsStream("/Images/bgdisplaychoose.png");

        if(streamchoose != null){
            bgImageMemilihCharacter.setImage(new Image(streamchoose));
            bgImageMemilihCharacter.fitWidthProperty().bind(rootmemilihcharacter.widthProperty());
            bgImageMemilihCharacter.fitHeightProperty().bind(rootmemilihcharacter.heightProperty());
        }else{
            System.out.println("gambar tidak ditemukan");
        }

        tambahEfekHoverMembesar(btnMemilihDraven);
        tambahEfekHoverMembesar(btnMemilihLyra);
        tambahEfekHoverMembesar(btnMemilihKaelion);

        System.out.println("Background berhasil di set");

        btnMemilihDraven.getStyleClass().add("btnMemilihDraven");

        btnMemilihKaelion.getStyleClass().add("btnMemilihKaelion");

        btnMemilihLyra.getStyleClass().add("btnMemilihLyra");

    }
    private void tambahEfekHoverMembesar(Button button) {
        ScaleTransition stIn = new ScaleTransition(Duration.millis(150), button);
        stIn.setToX(1.1);
        stIn.setToY(1.1);

        ScaleTransition stOut = new ScaleTransition(Duration.millis(150), button);
        stOut.setToX(1.0);
        stOut.setToY(1.0);

        button.setOnMouseEntered(e -> stIn.play());
        button.setOnMouseExited(e -> stOut.play());
}

    @FXML
    private void handlePlayerDraven(ActionEvent event)throws Exception{
        ChooseCharacter.setSelectedCharacter(draven);
        switchScene(event, "/fxml/lobby.fxml");
    }

    @FXML
    private void handlePlayerLyra(ActionEvent event)throws Exception{
        ChooseCharacter.setSelectedCharacter(lyra);
        switchScene(event, "/fxml/lobby.fxml");
    }

    @FXML
    private void handlePlayerKaelion(ActionEvent event)throws Exception{
        ChooseCharacter.setSelectedCharacter(kaelion);
        switchScene(event, "/fxml/lobby.fxml");
    }
}