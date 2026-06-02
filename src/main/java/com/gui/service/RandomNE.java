package com.gui.service;

import com.gui.model.CharacterMiniGame.Character;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import com.gui.model.CharacterMiniGame.Enemy.Dragon;
import com.gui.model.CharacterMiniGame.Enemy.Goblin;
import com.gui.model.CharacterMiniGame.NPC.Npc;

import javafx.application.Platform;

public class RandomNE {

    private ArrayList<Npc> npclist;
    private Random random;
    private Character player;
    private Consumer<String> onLog;
    private Consumer<String> onGambar;
    private Character musuhAktif;
    private Npc npcAktif;
    private Runnable onMati;
    
    public RandomNE(Character player, Consumer<String> onLog, Consumer<String> onGambar, Runnable onMati){
        npclist = new ArrayList<>();
        random = new Random();
        this.player = player;
        this.onLog = onLog;
        this.onGambar = onGambar;
        this.onMati = onMati;
        
        npclist.add(new Npc("Kakek buta"));

    }
    
    public Character getMusuhAktif() {
        return musuhAktif;
    }

    public Npc getNpcAktif() {
        return npcAktif;
    }

    public void attackDragon(){
        ScheduledExecutorService schedul = Executors.newScheduledThreadPool(1);
        npcAktif = null;
        onGambar.accept("npc_hilang");
        onGambar.accept("goblin_hilang");
        onGambar.accept("character_muncul");
        
        Dragon dragon = new Dragon("Dragon", 100, 5, false);
        musuhAktif = dragon;
        onGambar.accept("naga_muncul");
        onLog.accept("Kamu membangunkan naga yang sedang tertidur");

        schedul.scheduleAtFixedRate(() -> {
            if(player.getHp() != 0 && dragon.getHp() != 0){
                
                onGambar.accept("character_menyerang_hilang");
                Platform.runLater(() -> {
                    onGambar.accept("naga_nyerang");
                    dragon.attackCharacter(player);
                    onLog.accept("Dragon menyerangmu! HP tersisa: " + player.getHp());
                });
                schedul.schedule(() ->{
                    onGambar.accept("naga_muncul");
                }, 1, TimeUnit.SECONDS);
                
            }else{
                schedul.shutdown();
                Platform.runLater(() -> {
                    if(player.getHp() <= 0){
                        onMati.run();
                    }else{
                        onGambar.accept("naga_mati");
                        onGambar.accept("character_menyerang_hilang");
                    }
                });
            }
        }, 0, 2, TimeUnit.SECONDS);
    }

    public void randomEncounter(){
        if(!player.isAlive()){
            onLog.accept("kamu sudah mati");
            return;
        }

        int chance = random.nextInt(100);

        if (chance < 70) {
            // Encounter NPC
            musuhAktif = null;
            Npc npc = npclist.get(random.nextInt(npclist.size()));
            npcAktif = npc;
            onGambar.accept("character_muncul");
            onGambar.accept("goblin_hilang");
            onGambar.accept("npc_muncul");
            onLog.accept("Kamu bertemu dengan " + npc.getNama());
            onLog.accept("Tekan 'Bicara' untuk berinteraksi dengan " + npc.getNama());


        } else if (chance < 50) {
            ScheduledExecutorService schedul = Executors.newScheduledThreadPool(1);
            // Encounter Goblin
            npcAktif = null;
            onGambar.accept("npc_hilang");
            onGambar.accept("character_muncul");
            Goblin enemy = new Goblin("Goblin", 20, 10, false);
            musuhAktif = enemy;
            onGambar.accept("goblin_muncul");
            onLog.accept("Kamu bertemu dengan " + enemy.getUsername() + "!");

            schedul.scheduleAtFixedRate(() -> {
                if(player.getHp() != 0 && enemy.getHp() != 0){
                    Platform.runLater(() -> {
                        enemy.attackCharacter(player);
                        onLog.accept(enemy.getUsername() + " menyerangmu! HP tersisa: " + player.getHp());
                    });
                }else{
                    System.out.println("telah mati");
                    schedul.shutdown();
                    Platform.runLater(() -> {
                        onMati.run();
                    });
                }
            }, 0, 2, TimeUnit.SECONDS);

        } else {
            musuhAktif = null;
            npcAktif = null;
            onGambar.accept("character_muncul");
            onGambar.accept("npc_hilang");
            onGambar.accept("goblin_hilang");
            onLog.accept("Tidak ada yang terjadi, kamu melanjutkan perjalanan.");
        }
    }
}
