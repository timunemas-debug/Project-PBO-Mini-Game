package com.gui.controller;

import com.gui.service.ChooseCharacter;
import com.gui.service.Pertempuran;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.gui.model.CharacterMiniGame.Character;
import com.gui.model.CharacterMiniGame.Draven;
import com.gui.model.CharacterMiniGame.NPC.Npc;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

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
    private Button btnNpc;
    @FXML
    private Button btnNext;
    @FXML
    private Button btnHome;
    @FXML
    private TextArea logArea;
    @FXML
    private ImageView goblinImageView;
    @FXML
    private ImageView characterImageView;
    @FXML
    private ImageView npcImageView;
    @FXML
    private ImageView menambahDarahImageView;
    @FXML
    private ImageView gameoverImageView;


    private Pertempuran pertempuran;
    private Character player;
    private Random random = new Random();
    private PauseTransition logDelay = new PauseTransition(Duration.seconds(2));

    
    public void initialize(){
        System.out.println("INITIALIZE LOBBY DI CALL");
        var streampertempuran = getClass().getResourceAsStream("/Images/bgpertempuran.png");
        
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
    
    public void handleGambar(String state){

        Character selected = ChooseCharacter.getSelectCharacter();
        String namaCharacter = selected.getUsername();

        String characterPath = "/Images/Character" + namaCharacter + ".png";

        switch(state){

            case "character_muncul" -> {
                var stream = getClass().getResourceAsStream(characterPath);
                if(stream != null){
                    characterImageView.setImage(new Image(stream));
                    characterImageView.setVisible(true);
                }
            }

            case "character_get_heal" -> {
                var stream = getClass().getResourceAsStream("/Images/DisplayTambahDarah.png");
                if(stream != null){
                    menambahDarahImageView.setImage(new Image(stream));
                    menambahDarahImageView.setVisible(true);

                    PauseTransition delay = new PauseTransition(Duration.seconds(1));

                    delay.setOnFinished(e -> {
                        menambahDarahImageView.setVisible(false);
                    });

                    delay.play();
                }
            }

            case "character_mati" -> {
                var stream = getClass().getResourceAsStream("/Images/gameover.png");
                if(stream != null){
                    gameoverImageView.setImage(new Image(stream));
                    gameoverImageView.setVisible(true);
                }
            }

            case "goblin_muncul" -> {
                String[] backgrounds = {
                    "/Images/bgpertempuran.png",
                    "/Images/bgpertempuran2.png"
                };
                String randomBg = backgrounds[random.nextInt(backgrounds.length)];
                var bgStream = getClass().getResourceAsStream(randomBg);
                if(bgStream != null){
                    bgimagepertempuran.setImage(new Image(bgStream));
                }


                var stream = getClass().getResourceAsStream("/Images/GoblinHidupPertempuran.png");

                if(stream != null){
                    goblinImageView.setImage(new Image(stream));
                    goblinImageView.setVisible(true);
                }
            }

            case "goblin_mati" -> {
                var stream = getClass().getResourceAsStream("/Images/GoblinMatiPertempuran.png");

                if(stream != null){
                    goblinImageView.setImage(new Image(stream));
                    goblinImageView.setVisible(true);
                }
            }

            case "goblin_hilang" -> {
                goblinImageView.setVisible(false);
                }

            case "npc_muncul" -> {
                var stream = getClass().getResourceAsStream("/Images/npcPertempuran.png");
                if(stream != null){
                    bgimagepertempuran.setImage(new Image(stream));
                }
                npcImageView.setVisible(true);
            }

            case "npc_hilang" -> {
                var stream = getClass().getResourceAsStream("/Images/bgpertempuran.png");
                if(stream != null){
                    bgimagepertempuran.setImage(new Image(stream));
                }
                npcImageView.setVisible(false);
            }

        }
    }

    public void showLog(String msg){
        logArea.clear();
        logArea.appendText(msg);
        logArea.setVisible(true);

        logDelay.stop();
        logDelay.setOnFinished(e -> logArea.setVisible(false));
        logDelay.play();
    }

    public void setPlayer(Character player) {
        if(player == null){
            System.out.println("WARNING: setplayer dipanggil dengan null");
            return;
        }
        if(player instanceof Draven d){
            d.setOnLog(msg -> showLog(msg));
            d.setOnGambar(state -> handleGambar(state));
        }
        this.player = player;
        this.pertempuran = new Pertempuran(player,
            msg -> showLog(msg),
            state -> handleGambar(state)
        );
        showLog("Pertempuran dimulai! Selamat datang, " + player.getUsername() + "\n");
    }

    private void tampilNext() {
    String pesan = pertempuran.nextDialog();
    if (pesan != null) {
        showLog(pesan);
        btnNext.setVisible(true);
    } else {
        btnNext.setVisible(false);
        logArea.setVisible(false);
    }
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
    private void attackEnemy(ActionEvent event)throws Exception{
        if(pertempuran == null){
            System.out.println("EROR ATTACK ENEMY");
            return;
        }
        Character musuh = pertempuran.getMusuhAktif();
        if(musuh == null){
            showLog("tidak ada musuh untuk diserang!");
            return;
        }
        player.attackCharacter(musuh);

        if(musuh.getHp() <= 0){
            showLog("Goblin telah mati!\n");
            handleGambar("goblin_mati");
        }
    }
    
    @FXML
    private void gameOver(ActionEvent event)throws Exception{
        if(pertempuran == null){
            System.out.println("EROR: GAME OVER");
            return;
        }
        if(player.getHp() <= 0){
            btnHome.setDisable(false);
            
            btnJalan.setDisable(true);
            btnHeal.setDisable(true);
            btnNpc.setDisable(true);
            btnAttack.setDisable(true);

            showLog(player.getUsername() + "Telah mati");
            handleGambar("character_mati");

            PauseTransition delay = new PauseTransition(Duration.seconds(2));
            delay.setOnFinished(e -> {
                try {
                    switchScene(event, "/fxml/lobby.fxml");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            delay.play();
        }
    }

    @FXML
    private void bicaraNpc(ActionEvent event){
        pertempuran.mulaiDialogNpc();
        tampilNext();
    }

    @FXML
    private void nextDialog(ActionEvent event){
        tampilNext();
    }

    @FXML
    private void exitGame(ActionEvent event)throws Exception{
        switchScene(event, "/fxml/lobby.fxml");
    }
}
