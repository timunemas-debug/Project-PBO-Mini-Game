package com.gui.service;

import java.util.Scanner;
import com.gui.model.CharacterMiniGame.Character;

import com.gui.model.CharacterMiniGame.Enemy.Goblin;
import com.gui.model.CharacterMiniGame.Character.DisplayPlayer;

public class DisplayMenu {
    private Scanner input = new Scanner(System.in);
    
    private ChooseCharacter choose = new ChooseCharacter();
    private Character selectedCharacter;
    Goblin goblin = new Goblin("Goblin", 20, 10, false);


    public void start(){
        System.out.println("------------------------------");
        System.out.println("SELAMAT DATANG DI MINI GAME");
        System.out.println("           MULAI           ");
        System.out.println("------------------------------");
        System.out.print("Ketik 1 jika ingin memulai! : ");

        try {
            int play = input.nextInt();
            input.nextLine();
            if(play == 1){
                displayMainMenu();
            }else{
                System.out.println("Terima kasih sudah bermain");
            }
        } catch (Exception e) {
            System.out.println("Input harus angka!");
            input.nextLine();
        }
    }
    
    public void displayMainMenu(){
        while (true) {
            System.out.println("--------------------");
            System.out.println("1. Start Game");
            System.out.println("2. Inventory");
            System.out.println("3. Profil");
            System.out.println("4. Keluar");
            System.out.println("--------------------");
            System.out.print("Memilih : ");

            try {
                int menu = input.nextInt();
                input.nextLine();
                switch (menu) {
                    case 1 :
                        System.out.println("Memasuki permainan....");
                        choose.chooseCharacter();
                        selectedCharacter = ChooseCharacter.getSelectCharacter();
                        Pertempuran pertempuran = new Pertempuran(selectedCharacter);
                        pertempuran.startPertempuran();
                        break;
                    case 2 :
                        if(selectedCharacter != null){
                            selectedCharacter.getInventoryPlayer().inventoryPlayer();
                        }else{
                            System.out.println("Belum memilih karakter!");
                        }
                        break;
                    case 3 :
                        if(selectedCharacter != null){
                            ((DisplayPlayer) selectedCharacter).displayPlayer();
                        }else{
                            System.out.println("Belum ada karakter yang dipilih");
                        }
                        break;
                    case 4 :
                        System.out.println("Keluar dari game");
                        return;
                    default:
                        break;
                    }
            } catch (Exception e) {
                System.out.println("Input harus angka!");
                input.nextLine();
            }
        }
    }
}
