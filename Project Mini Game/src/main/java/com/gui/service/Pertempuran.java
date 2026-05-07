package com.gui.service;

import com.gui.model.CharacterMiniGame.Character;
import java.util.Scanner;

import com.gui.model.CharacterMiniGame.Character.Heal;

public class Pertempuran {
    private Character player;
    private RandomNE encounter;
    private Scanner input = new Scanner(System.in);

    public Pertempuran(Character player){
        this.player = player;
        encounter = new RandomNE(player);
    }

    public void startPertempuran(){
        while (player.getHp() > 0) {
            
            System.out.println("------------------------------");
            System.out.println("             Aksi             ");
            System.out.println("------------------------------");
            System.out.println("1. Jalan");
            System.out.println("2. Heal");
            System.out.println("------------------------------");
            System.out.print("Pilih aksi : ");
            int pilihAksi = input.nextInt();
            input.nextLine();

            if(pilihAksi == 1){
                encounter.randomEncounter();
            }
            else if(pilihAksi == 2){
                ((Heal) player).heal();
            }
        }
        if(player.getHp() <= 10){
            System.out.println("Kamu butuh darah!!!");
            System.out.print("Apakah kamu ingin menambah darah? (Y/N) : ");
            String menambahDarah = input.nextLine();
            if(menambahDarah.equalsIgnoreCase("Y")){
                ((Heal) player).heal();
            }else{
                System.out.println("Kamu Kalah!");
            }
        }
    }

}
