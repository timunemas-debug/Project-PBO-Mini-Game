package com.gui.service;

import com.gui.model.CharacterMiniGame.Character;
import com.gui.model.CharacterMiniGame.NPC.Npc;
import java.util.Scanner;
import java.util.function.Consumer;

import com.gui.model.CharacterMiniGame.Character.Heal;
import com.gui.model.CharacterMiniGame.Character.DisplayPlayer;


public class Pertempuran {
    private Character player;
    private RandomNE encounter;
    private Consumer<String> onLog;
    private Consumer<String> onCounter;
    private Consumer<String> onGambar;
    private DialogManager dialogManager = new DialogManager();

    private Scanner input = new Scanner(System.in);

    public Pertempuran(Character player){
        this(player, System.out::println, gambar -> {});
    }

    public Pertempuran(Character player, Consumer<String> onLog, Consumer<String> onGambar){
        this.player = player;
        this.onLog = onLog;
        this.onGambar = onGambar;
        encounter = new RandomNE(player, onLog, onGambar);
    }

    public Character getPlayer() {
        return player;
    }

    public void aksiJalan(){
        encounter.randomEncounter();
    }

    public void aksiHeal(){
        ((Heal) player).heal();
    }

    public Character getMusuhAktif(){
        return encounter.getMusuhAktif();
    }

    public Npc getNpcAktif(){
        return encounter.getNpcAktif();
    }

    public void mulaiDialogNpc(){
        Npc npc = getNpcAktif();
        dialogManager.load(log -> {
            npc.kalimatNpcGretting(log);
            npc.misiNpc(log);
            npc.misiNpcMiniBos(log);
        });
    }

    public String nextDialog(){
        return dialogManager.next();
    }

    public boolean isDialogSelesai(){
        return dialogManager.isSelesai();
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
                        System.out.println("Pilihan anda tidak valid");
                }
            } catch (Exception e) {
                System.out.println("EROR: Harus berupa angka");
                onLog.accept("Input harus berupa angka!");
                input.nextLine();
            }
        }
        if(player.getHp() <= 10){
            onLog.accept("Kamu butuh darah!!!");
            onLog.accept("Apakah kamu ingin menambah darah? (Y/N) : ");
            String menambahDarah = input.nextLine();
            if(menambahDarah.equalsIgnoreCase("Y")){
                ((Heal) player).heal();
            }else{
                onLog.accept("Kamu Kalah!");
            }
        }
    }
}