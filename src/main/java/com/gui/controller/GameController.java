package com.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class GameController extends BaseController{

    @FXML
    private StackPane rootpertempuran;
    @FXML
    private ImageView bgimagepertempuran;
    @FXML
    private Button btnJalan;
    @FXML
    private Button btnHeal;
    @FXML
    private Button btnExit;

    @FXML
    public void initialize(){
        System.out.println("INITIALIZE LOBBY DI CALL");
        var streampertempuran = getClass().getResourceAsStream("/Images/bgpertempuran1.png");

        if(streampertempuran != null){
            bgimagepertempuran.setImage(new Image(streampertempuran));
            bgimagepertempuran.fitWidthProperty().bind(rootpertempuran.widthProperty());
            bgimagepertempuran.fitHeightProperty().bind(rootpertempuran.heightProperty());
        }else{
            System.out.println("Gambar tidak ditemukan");
        }

        System.out.println("Background pertempuran berhasil di set");
    }

    @FXML
    private void exitGame(ActionEvent event)throws Exception{
        switchScene(event, "/fxml/lobby.fxml");
    }
}
