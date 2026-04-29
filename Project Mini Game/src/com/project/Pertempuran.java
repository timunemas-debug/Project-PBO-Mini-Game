package com.project;

import java.util.Scanner;
import com.project.Character.Heal;

public class Pertempuran {
    private Character player;
    private Character enemy;
    private Scanner input = new Scanner(System.in);

    public Pertempuran(Character player, Character enemy){
        this.player = player;
        this.enemy = enemy;
    }

    public void startPertempuran(){
        while (player.getHp() > 0 && enemy.getHp() > 0) {

            System.out.println("\nAksi");
            System.out.println("1. Jalan");
            System.out.println("2. Heal");
            System.out.println("Pilih aksi");
            int pilihAksi = input.nextInt();
            input.nextLine();

            if(pilihAksi == 1){
                System.out.print("Anda bertemu dengan " + enemy.getUsername() + " Apakah anda ingin menyerang? (Y/N): ");
                String penyerangan = input.nextLine();
                if(penyerangan.equalsIgnoreCase("Y")){
                    player.attackCharacter(enemy);
                }else{
                    System.out.println("Anda melewati " + enemy.getUsername());
                }
            }
            else if(pilihAksi == 2){
                ((Heal) player).heal();
            }
            if(enemy.getHp() > 0){
                enemy.attackCharacter(player);
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
