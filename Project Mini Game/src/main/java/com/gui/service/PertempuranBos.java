package com.gui.service;
import java.util.Scanner;

import com.gui.model.CharacterMiniGame.Character;
import com.gui.model.CharacterMiniGame.Character.Heal;
import com.gui.model.CharacterMiniGame.Character.DisplayPlayer;

public class PertempuranBos extends Pertempuran{
    private Character enemy;
    private Scanner input = new Scanner(System.in);


    public PertempuranBos(Character player, Character enemy){
        super(player);
        this.enemy = enemy;
    }

    @Override
    public void startPertempuran(){
        while (enemy.getHp() > 0 && getPlayer().getHp() > 0) {
            System.out.println("------------------------------");
            System.out.println("             Aksi             ");
            System.out.println("------------------------------");
            System.out.println("1. Serang");
            System.out.println("2. Heal");
            System.out.println("3. Info");
            System.out.println("4. Keluar");
            System.out.println("------------------------------");
            System.out.print("Pilih aksi : ");
            int pilihaksi = input.nextInt();
            input.nextLine();

            if(pilihaksi == 1){
                getPlayer().attackCharacter(enemy);
                if(enemy.getHp() > 0){
                    enemy.attackCharacter(getPlayer());
                }else{
                    System.out.println(enemy.getUsername() + "Berhasil dikalahkan!");
                }
            }
            else if(pilihaksi == 2){
                ((Heal) getPlayer()).heal();
            }
            else if(pilihaksi == 3){
                ((DisplayPlayer)getPlayer()).displayPlayer();
            }
            else if(pilihaksi == 4){
                System.out.println("Keluar..");
                break;
            }
        }
        if(getPlayer().getHp() <= 0){
            System.out.println("Kamu butuh darah");
            System.out.println("Apakah kamu ingin menambah darah? (Y/N) : ");
            String menambahDarah = input.nextLine();
            if(menambahDarah.equalsIgnoreCase("Y")){
                ((Heal) getPlayer()).heal();
            }
        }
    }
}
