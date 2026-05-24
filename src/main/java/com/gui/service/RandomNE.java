package com.gui.service;

import com.gui.model.CharacterMiniGame.Character;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;

import com.gui.model.CharacterMiniGame.Enemy.Dragon;
import com.gui.model.CharacterMiniGame.Enemy.Goblin;
import com.gui.model.CharacterMiniGame.NPC.Npc;

public class RandomNE {
    private ArrayList<Npc> npclist;
    private ArrayList<Goblin> enemylist;
    private ArrayList<Dragon> miniboslist;
    private Random random;
    private Character player;
    private Consumer<String> onLog;
    private Consumer<String> onCounter;
    private Goblin musuhAktif;
    
    public RandomNE(Character player, Consumer<String> onLog, Consumer<String> onCounter){
        npclist = new ArrayList<>();
        enemylist = new ArrayList<>();
        miniboslist = new ArrayList<>();
        random = new Random();
        this.player = player;
        this.onLog = onLog;
        this.onCounter = onCounter;
        
        npclist.add(new Npc("Kakek buta"));
        enemylist.add(new Goblin("Goblin", 20, 10, false));
        miniboslist.add(new Dragon("Dragon", 20, 30, false));

    }
    
    public Goblin getMusuhAktif() {
        return musuhAktif;
    }

    public void randomEncounter(){
        int chance = random.nextInt(100);

        if (chance < 20) {
            // Encounter NPC
            Npc npc = npclist.get(random.nextInt(npclist.size()));
            onCounter.accept("npc");
            onLog.accept("Kamu bertemu dengan " + npc.getNama());
            onLog.accept("Tekan 'Bicara' untuk berinteraksi dengan " + npc.getNama());


        } else if (chance < 80) {
            // Encounter Goblin
            Goblin enemy = enemylist.get(random.nextInt(enemylist.size()));
            onCounter.accept("goblin");
            musuhAktif = enemy;
            onLog.accept("Kamu bertemu dengan " + enemy.getUsername() + "!");
            enemy.attackCharacter(player);
            onLog.accept(enemy.getUsername() + " menyerangmu! HP tersisa: " + player.getHp());

        } else {
            musuhAktif = null;
            onCounter.accept("default");
            onLog.accept("Tidak ada yang terjadi, kamu melanjutkan perjalanan.");
        }
    }
}
