package com.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private StackPane root;
    @FXML
    private Button btnStart;
    @FXML
    private Button btnExit;
    @FXML
    private ImageView bgImage;

    @FXML
    public void initialize(){
        System.out.println("INITIALIZE DIPANGGIL");
        var stream = getClass().getResourceAsStream("/Images/bgdisplayfirst.png");

        if(stream == null){
            System.out.println("Gambar tidak ditemukan");
            return;
        }

        Image bg = new Image(stream);
        bgImage.setImage(bg);

        bgImage.fitWidthProperty().bind(root.widthProperty());
        bgImage.fitHeightProperty().bind(root.heightProperty());

        System.out.println("BACKGROUND BERHASIL DI SET");

        btnStart.getStyleClass().clear();
        btnStart.getStyleClass().add("btn-start");
            
        btnExit.getStyleClass().clear();
        btnExit.getStyleClass().add("btn-exit");

        }

    @FXML
    private void startGame(ActionEvent event) throws Exception {

        Parent newRoot = FXMLLoader.load(
                getClass().getResource("/fxml/choose-character.fxml")
        );

        Scene scene = new Scene(newRoot, 1280,720);
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