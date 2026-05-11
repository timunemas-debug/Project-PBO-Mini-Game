package com.gui.service;

import com.gui.model.CharacterMiniGame.Character;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.gui.model.CharacterMiniGame.Enemy.Dragon;
import com.gui.model.CharacterMiniGame.Enemy.Goblin;
import com.gui.model.CharacterMiniGame.NPC.Npc;

public class RandomNE {
    private ArrayList<Npc> npclist;
    private ArrayList<Goblin> enemylist;
    private ArrayList<Dragon> miniboslist;
    private Random random;
    private Character player;
    Scanner input = new Scanner(System.in);

    public RandomNE(Character player){
        npclist = new ArrayList<>();
        enemylist = new ArrayList<>();
        miniboslist = new ArrayList<>();
        random = new Random();
        this.player = player;
        
        npclist.add(new Npc("Kakek buta"));
        enemylist.add(new Goblin("Goblin", 20, 10, false));
        miniboslist.add(new Dragon("Dragon", 20, 30, false));

    }

    public void randomEncounter(){
        int chance = random.nextInt(100);

        if(chance < 20){
            Npc npc = npclist.get(random.nextInt(npclist.size()));
            Dragon miniBos = miniboslist.get(random.nextInt(miniboslist.size()));
            System.out.println("Kamu bertemu dengan " + npc.getNama());
            System.out.println("--------------------------------------------");
            System.out.print("Apakah anda ingin berbicara dengan ? " + npc.getNama() + " (Y/N) : ");
            String berbicara = input.nextLine();
            if(berbicara.equalsIgnoreCase("Y")){
                npc.kalimatNpcGretting();
                npc.misiNpc();
                System.out.println("Apakah anda ingin membantu kakek tua? (Y/N) : ");
                String membantu = input.nextLine();
                if(membantu.equalsIgnoreCase("Y")){
                    npc.miniNpcMiniBos();
                    PertempuranBos pertempuranBos = new PertempuranBos(player, miniBos);
                    pertempuranBos.startPertempuran();
                    if(miniBos.getHp() <= 0){
                        npc.hadiah();
                        player.getChest();
                    }
                }
            }
        }
        else if(chance < 80){
            Goblin enemy = enemylist.get(random.nextInt(enemylist.size()));
            System.out.println("Kamu bertemu dengan " + enemy.getUsername());
            System.out.println("--------------------------------------------");
            enemy.attackCharacter(player);
            System.out.print("Apakah anda ingin menyerang enemy? (Y/N) : ");
            String menyerang = input.nextLine();
            if(menyerang.equalsIgnoreCase("Y")){
                player.attackCharacter(enemy);
            }
        }else{
            System.out.println("Tidak ada yang terjadi");
        }
    }
}
