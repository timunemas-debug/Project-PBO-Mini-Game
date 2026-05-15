package com.gui.service;

import com.gui.model.CharacterMiniGame.Character;

import java.util.Scanner;

import com.gui.model.CharacterMiniGame.Character.Heal;
import com.gui.model.CharacterMiniGame.Character.DisplayPlayer;

public class Pertempuran {
    private Character player;
    private RandomNE encounter;
    private Scanner input = new Scanner(System.in);

    public Pertempuran(Character player){
        this.player = player;
        encounter = new RandomNE(player);
    }

    public Character getPlayer() {
        return player;
    }

    public void startPertempuran(){
        while (player.getHp() > 0) {
            
            System.out.println("------------------------------");
            System.out.println("             Aksi             ");
            System.out.println("------------------------------");
            System.out.println("1. Jalan");
            System.out.println("2. Heal");
            System.out.println("3. Item");
            System.out.println("4. Info");
            System.out.println("5. Keluar");
            System.out.println("------------------------------");
            System.out.print("Pilih aksi : ");

            try {
                int pilihAksi = input.nextInt();
                input.nextLine();
                switch (pilihAksi) {
                    case 1 :
                        encounter.randomEncounter();
                        break;
                    case 2 :
                        ((Heal) player).heal();
                        break;
                    case 3 :
                        player.getInventoryPlayer().useItemPlayer();
                        break;
                    case 4 :
                        ((DisplayPlayer) player).displayPlayer();
                        break;
                    case 5 :
                        return;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                input.nextLine();
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
