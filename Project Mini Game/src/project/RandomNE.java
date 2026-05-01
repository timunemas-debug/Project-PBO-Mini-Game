package project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RandomNE {
    private ArrayList<Npc> npclist;
    private ArrayList<Goblin> enemylist;
    private Random random;
    private Character player;
    Scanner input = new Scanner(System.in);

    public RandomNE(Character player){
        npclist = new ArrayList<>();
        enemylist = new ArrayList<>();
        random = new Random();
        this.player = player;
        
        npclist.add(new Npc("Kakek buta"));
        enemylist.add(new Goblin("Goblin", 20, 10, false));
    }

    public void randomEncounter(){
        int chance = random.nextInt(100);

        if(chance < 50){
            Npc npc = npclist.get(random.nextInt(npclist.size()));
            System.out.println("Kamu bertemu dengan " + npc.getNama());
            System.out.println("--------------------------------------------");
            System.out.print("Apakah anda ingin berbicara dengan ?"+ npc.getNama() + " (Y/N) : ");
            String berbicara = input.nextLine();
            if(berbicara.equalsIgnoreCase("Y")){
                npc.kalimatNpcGretting();
                npc.misiNpc();
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
