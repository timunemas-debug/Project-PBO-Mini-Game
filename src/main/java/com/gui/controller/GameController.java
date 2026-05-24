package com.gui.controller;

import com.gui.service.ChooseCharacter;
import com.gui.service.Pertempuran;
import com.gui.model.CharacterMiniGame.Character;
import com.gui.model.CharacterMiniGame.Draven;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
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
    private Button btnAttack;
    @FXML
    private TextArea logArea;

    private Pertempuran pertempuran;
    private Character player;

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
        
        Character selectedPlayer = ChooseCharacter.getSelectCharacter();
        if(selectedPlayer != null){
            setPlayer(selectedPlayer);
        }else{
            System.out.println("EROR: Tidak ada karakter yang dipilih");
            btnJalan.setDisable(true);
            btnHeal.setDisable(true);
        }
    }

    public void gantiBackground(String type){
        String imagePath = switch(type){
            case "goblin" -> "/Images/goblinPertempuran.png";
            case "npc" -> "/Images/npcPertempuran.png";
            case "default" -> "/Images/bgPertempuran1.png";
            default -> "";
        };

        var stream = getClass().getResourceAsStream(imagePath);
        if(stream != null){
            bgimagepertempuran.setImage(new Image(stream));
        }
    }
    
    public void setPlayer(Character player) {
        this.player = player;
        if(player == null){
            System.out.println("WARNING: setplayer dipanggil dengan null");
        }
        if(player instanceof Draven d){
            d.setOnLog(msg -> logArea.appendText(msg + "\n"));
        }
        this.player = player;
        this.pertempuran = new Pertempuran(player,
            msg -> logArea.appendText(msg + "\n"),
            type -> gantiBackground(type));
        logArea.appendText("Pertempuran dimulai! Selamat datang, " + player.getUsername() + "\n");
    }
    
    @FXML
    private void onJalan(ActionEvent event){
        if(pertempuran == null){
            System.out.println("EROR ON JALAN");
        }
        pertempuran.aksiJalan();
    }

    @FXML
    private void nambahDarah(ActionEvent event){
        if(pertempuran == null){
            System.out.println("EROR MENAMBAH DARAH");
        }
        pertempuran.aksiHeal();
    }

    @FXML
    private void attackEnemy(ActionEvent event){
        if(pertempuran == null){
            System.out.println("EROR ATTACK ENEMY");
            return;
        }
        Character musuh = pertempuran.getMusuhAktif();
        if(musuh == null){
            logArea.appendText("tidak ada musuh untuk diserang!");
            return;
        }
        player.attackCharacter(musuh);
    }

    @FXML
    private void exitGame(ActionEvent event)throws Exception{
        switchScene(event, "/fxml/lobby.fxml");
    }
}
