package com.gui.controller;

import com.gui.service.ChooseCharacter;
import com.gui.model.CharacterMiniGame.Character;
import com.gui.model.CharacterMiniGame.Draven;
import com.gui.model.CharacterMiniGame.Lyra;
import com.gui.model.CharacterMiniGame.Kaelion;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;

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
    private Label lblLevel;
    @FXML
    private Label lblWeapon;
    @FXML
    private Label lblArmor;
    @FXML
    private Label lblMagic;
    @FXML
    private Label lblNama;

    @FXML
    public void initialize(){
        Character selected = ChooseCharacter.getSelectCharacter();
        if(selected != null){
            String namaCharacter = selected.getUsername();

            String imagepath = "/Images/" + namaCharacter +"Pp" + ".png";
            var stream = getClass().getResourceAsStream(imagepath);

            if(stream != null){
                imgCharacter.setImage(new Image(stream));
            }else{
                System.out.println("GAMBAR TIDAK DITEMUKAN " + imagepath);
            }
        }
        
        if(selected instanceof Draven draven){
            lblNama.setText("Nama : " + draven.getUsername());
            lblLevel.setText("Level : " + draven.getLevel());
            lblWeapon.setText("Weapon : " + draven.getWeapon());
            lblArmor.setText("Armor : " + draven.getArmor());
            lblMagic.setText("Skill : " + draven.getSkill());
        }
        else if(selected instanceof Lyra lyra){
            lblNama.setText("Nama : " + lyra.getUsername());
            lblLevel.setText("Level : " + lyra.getLevel());
            lblWeapon.setText("Weapon : " + lyra.getWeapon());
            lblArmor.setText("Armor : " + lyra.getArmor());
            lblMagic.setText("Skill : " + lyra.getSkill());
        }
        else if(selected instanceof Kaelion kaelion){
            lblNama.setText("Nama : " + kaelion.getUsername());
            lblLevel.setText("Level : " + kaelion.getLevel());
            lblWeapon.setText("Weapon : " + kaelion.getWeapon());
            lblArmor.setText("Armor : " + kaelion.getArmor());
            lblMagic.setText("Skill : " + kaelion.getSkill());
        }
        
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
        
        
        System.out.println("INITIALIZE PROFILE");
    }

    @FXML
    private void exitGame(ActionEvent event)throws Exception{
        switchScene(event, "/fxml/lobby.fxml");
    }
}