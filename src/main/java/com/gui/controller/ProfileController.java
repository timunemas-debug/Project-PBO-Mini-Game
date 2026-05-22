package com.gui.controller;

import com.gui.service.ChooseCharacter;
import com.gui.model.CharacterMiniGame.Character;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class ProfileController extends BaseController{

    @FXML
    private StackPane rootprofile;
    @FXML
    private Button btnExit;
    @FXML
    ImageView bgImageProfile;
    @FXML
    ImageView imgCharacter;

    @FXML
    public void initialize(){
        Character selected = ChooseCharacter.getSelectCharacter();
        if(selected != null){
            String namaCharacter = selected.getUsername();

            String imagepath = "/Images/" + namaCharacter + ".png";
            var stream = getClass().getResourceAsStream(imagepath);

            if(stream != null){
                imgCharacter.setImage(new Image(stream));
            }else{
                System.out.println("GAMBAR TIDAK DITEMUKAN " + imagepath);
            }
        }

        System.out.println("INITIALIZE PROFILE");
        var streamprofile = getClass().getResourceAsStream("/Images/bgprofile.png");

        if(streamprofile == null){
            System.out.println("GAMBAR TIDAK ADA");
            return;
        }

        Image bg = new Image(streamprofile);
        bgImageProfile.setImage(bg);

        bgImageProfile.fitWidthProperty().bind(rootprofile.widthProperty());
        bgImageProfile.fitHeightProperty().bind(rootprofile.heightProperty());


        System.out.println("BG BERHASIL DI SET");
    }

    @FXML
    private void exitGame(ActionEvent event)throws Exception{
        switchScene(event, "/fxml/lobby.fxml");
    }
}