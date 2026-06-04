package com.gui.controller;

import java.util.Random;

import com.gui.model.CharacterMiniGame.Character;
import com.gui.model.CharacterMiniGame.Draven;
import com.gui.model.CharacterMiniGame.Enemy.Goblin;
import com.gui.model.CharacterMiniGame.Enemy.Dragon;
import com.gui.model.CharacterMiniGame.Item;
import com.gui.service.*;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class GameController extends BaseController{
    private static final String BG_PERTEMPURAN = "/Images/bgpertempuran.png";
    private static final String BG_PERTEMPURAN_2 = "/Images/bgpertempuran2.png";
    private static final String BG_PERTEMPURAN_NAGA = "/Images/bgpertempurannaga.png";
    private static final String IMG_GOBLIN_HIDUP = "/Images/GoblinHidupPertempuran.png";
    private static final String IMG_GOBLIN_MATI = "/Images/GoblinMatiPertempuran.png";
    private static final String IMG_NAGA_MUNCUL = "/Images/nagamuncul.png";
    private static final String IMG_NAGA_MATI = "/Images/nagamati.png";

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
    private Button btnHadiah;
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
    private ImageView characterMatiImageView;
    @FXML
    private ImageView nagaImageView;
    @FXML
    private ImageView gameoverbgImageView;
    @FXML
    private ImageView characterMenyeranImageView;
    @FXML
    private ImageView hadiahImageView;
    @FXML
    private ImageView petiImageView;
    private Reward rewardService = new Reward();
    private Pertempuran pertempuran;
    private Character player;
    private Random random = new Random();
    private PauseTransition logDelay = new PauseTransition(Duration.seconds(2));
    private ActionEvent lastEvent;
    private RandomNE encounter;

    
    public void initialize(){
        System.out.println("INITIALIZE LOBBY DI CALL");
        var streampertempuran = getClass().getResourceAsStream(BG_PERTEMPURAN);
        
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

    private void loadImage(ImageView view, String path){
        var stream = getClass().getResourceAsStream(path);
        if(stream != null){
            view.setImage(new Image(stream));
            view.setVisible(true);
        }else{
            System.out.println("WARNING: Gambar tidak ditemukan -> " + path);
        }
    }

    public void handleGambar(String state){

        Character selected = ChooseCharacter.getSelectCharacter();
        String namaCharacter = selected.getUsername();

        String characterPath = "/Images/Character" + namaCharacter + ".png";

        switch(state){

            case "character_muncul" -> {
                loadImage(characterImageView, characterPath);
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
                loadImage(characterMatiImageView,"/Images/dravenMatiPertempuran.png");
            }

            case "character_menyerang" -> {
                String[] backgrounds = {
                    "/Images/dravenmenyerang.png",
                    "/Images/dravenmenyerang2.png"
                };
                String randomMenyerang = backgrounds[random.nextInt(backgrounds.length)];
                loadImage(characterMenyeranImageView, randomMenyerang);
            }

            case "character_hilang" -> {
                characterImageView.setVisible(false);
            }
            
            case "character_menyerang_hilang" -> {
                characterMenyeranImageView.setVisible(false);
            }

            case "goblin_muncul" -> {
                String[] backgrounds = {
                    BG_PERTEMPURAN,
                    BG_PERTEMPURAN_2
                };
                String randomBg = backgrounds[random.nextInt(backgrounds.length)];
                var bgStream = getClass().getResourceAsStream(randomBg);
                if(bgStream != null){
                    bgimagepertempuran.setImage(new Image(bgStream));
                }


                var stream = getClass().getResourceAsStream(IMG_GOBLIN_HIDUP);
                if(stream != null){
                    goblinImageView.setImage(new Image(stream));
                    goblinImageView.setVisible(true);
                }
            }

            case "goblin_mati" -> {
                loadImage(goblinImageView, IMG_GOBLIN_MATI);
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
                var stream = getClass().getResourceAsStream(BG_PERTEMPURAN);
                if(stream != null){
                    bgimagepertempuran.setImage(new Image(stream));
                }
                npcImageView.setVisible(false);
            }

            case "hadiah_npc" -> {
                var stream = getClass().getResourceAsStream("/Images/npc_hadiah_pertempuran.png");
                if(stream != null){
                    bgimagepertempuran.setImage(new Image(stream));
                }
                npcImageView.setVisible(false);
            }

            case "naga_tidur_muncul" -> {
                var stream = getClass().getResourceAsStream("/Images/nagaPertempuran.png");
                if(stream != null){
                    bgimagepertempuran.setImage(new Image(stream));
                }
            }

            case "naga_muncul" -> {
                var stream_background_naga = getClass().getResourceAsStream(BG_PERTEMPURAN_NAGA);
                if(stream_background_naga != null){
                    bgimagepertempuran.setImage(new Image(stream_background_naga));
                }

                loadImage(nagaImageView, IMG_NAGA_MUNCUL);
            }

            case "naga_nyerang" -> {
                loadImage(nagaImageView, "/Images/naga_nyerang.png");
            }

            case "naga_hilang" -> {
                var stream = getClass().getResourceAsStream(BG_PERTEMPURAN_NAGA);
                if(stream != null){
                    nagaImageView.setVisible(false);
                }
            }

            case "naga_mati" -> {
                loadImage(nagaImageView, IMG_NAGA_MATI);
            }

            case "gameover_muncul" -> {
                loadImage(gameoverbgImageView, "/Images/gameoverbg.png");
            }
            
            case "hadiah_random" -> {
                String[] hadiah = {
                    "/Images/hadiahpedang.png",
                    "/Images/hadiaharmor.png"
                };
                String randomHadiah = hadiah[random.nextInt(hadiah.length)];
                loadImage(hadiahImageView, randomHadiah);
            }

            case "peti_terbuka" -> {
                loadImage(petiImageView, "/Images/petiterbuka.png");
            }

            case "peti_tertutup" -> {
                loadImage(petiImageView, "/Images/petitertutup.png");
            }
            
            case "peti_hilang" -> {
                petiImageView.setVisible(false);
            }

        }
    }

    private void gameOverCharacter()throws Exception{
        if(player == null){
            System.out.println("EROR: GAME OVER");
            return;
        }
        if(player.getHp() <= 0){
            btnHome.setVisible(true);
            btnHome.setDisable(false);
            btnJalan.setDisable(true);
            btnHeal.setDisable(true);
            btnNpc.setDisable(true);
            btnAttack.setDisable(true);
            btnExit.setDisable(true);
            btnNext.setVisible(true);
            btnNext.setDisable(true);

            handleGambar("character_hilang");
            handleGambar("character_mati");
            handleGambar("gameover_muncul");
            handleGambar("character_menyerang_hilang");

            showLog(player.getUsername() + " Telah mati");
    
            PauseTransition delay = new PauseTransition(Duration.seconds(20));
            delay.setOnFinished(e -> {
                try {
                    switchScene(lastEvent, "/fxml/lobby.fxml");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
            delay.play();
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
        this.pertempuran = new Pertempuran(
            player,
            msg -> showLog(msg),
            state -> handleGambar(state),
            () -> {
                try {
                    gameOverCharacter();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },
            () -> {
                btnHadiah.setVisible(true);
                btnHadiah.setDisable(false);
            }
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
        if(pertempuran.getMusuhAktif() != null){
            btnNpc.setDisable(true);
        }
    }
}
    
    @FXML
    private void onJalan(ActionEvent event){
        lastEvent = event;
        if(pertempuran == null){
            System.out.println("EROR ON JALAN");
            return;
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
        handleGambar("character_menyerang");
        handleGambar("character_hilang");
        
        btnJalan.setVisible(false);
        btnNpc.setVisible(false);


        PauseTransition pause = new PauseTransition(Duration.millis(600));

        pause.setOnFinished(e -> {

            handleGambar("character_muncul");
            handleGambar("character_menyerang");
            handleGambar("character_menyerang_hilang");

            if(musuh.getHp() <= 0){
                showLog(musuh.getUsername() + " Sudah mati\n");
                if(musuh instanceof Goblin){
                    handleGambar("goblin_mati");
                    handleGambar("character_muncul");
                    btnJalan.setVisible(true);
                    btnNpc.setVisible(true);

                }else if(musuh instanceof Dragon){
                    handleGambar("naga_mati");
                    handleGambar("character_muncul");
                    btnJalan.setVisible(true);

                }
            }

            try {
                gameOverCharacter();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        pause.play();
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
    private void hadiahNpc(ActionEvent event){
        handleGambar("peti_terbuka");
        handleGambar("hadiah_random");
        handleGambar("peti_hilang");
        btnHadiah.setDisable(true);

        Item item = rewardService.getRandomItem();

        if(item.getType().equals("Weapon")){
            player.setAttackPower(player.getAttackPower() + item.getPlusPower());
            showLog("Kamu mendapatkan " + item.getName() + "! ATK + " + item.getPlusPower());
        }else if(item.getType().equals("Armor")){
            player.setHp(player.getHp() + item.getPlusPower());
            showLog("Kamu mendapatkan " + item.getName() + "! HP + " + item.getPlusPower());
        }

        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(e -> {
            hadiahImageView.setVisible(false);
            petiImageView.setVisible(false);
            btnHadiah.setVisible(false);
        });
        delay.play();
    }

    @FXML
    private void exitGame(ActionEvent event)throws Exception{
        switchScene(event, "/fxml/lobby.fxml");
    }
}
