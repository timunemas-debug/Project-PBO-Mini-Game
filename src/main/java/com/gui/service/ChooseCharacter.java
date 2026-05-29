//SUDAH DI IMPLEMENTASI KE FX

package com.gui.service;

import com.gui.model.CharacterMiniGame.Character;
import com.gui.model.CharacterMiniGame.Draven;
import com.gui.model.CharacterMiniGame.Lyra;
import com.gui.model.CharacterMiniGame.Kaelion;
import java.util.Scanner;

public class ChooseCharacter {
    private Scanner input = new Scanner(System.in);
    private Draven draven = new Draven("Draven", 85, 30, 0, true, 85);
    private Lyra lyra = new Lyra("Lyra", 90, 25, 0, 0, true, 90);
    private Kaelion kaelion = new Kaelion("Kaelion", 110, 20, 0, 0, true, 110);
    private static Character selectedCharacter;

    public void chooseCharacter(){
        while (true) {
            System.out.println("------------------------------");
            System.out.println("   MEMILIH KARAKTER   ");
            System.out.println("------------------------------");
            System.out.println("1. Draven");
            System.out.println("2. Lyra");
            System.out.println("3. Kaelion");
            System.out.println("4. Keluar");
            System.out.println("------------------------------");
            System.out.print("Memilih : ");
            int playerInputCharacter = input.nextInt();
            input.nextLine();
    
            if(playerInputCharacter == 1){
                selectedCharacter = draven;
                draven.displayPlayer();
                break;
            }
            else if(playerInputCharacter == 2){
                selectedCharacter = lyra;
                lyra.displayPlayer();
                break;
            }
            else if(playerInputCharacter == 3){
                selectedCharacter = kaelion;
                kaelion.displayPlayer();
                break;
            }
            else if(playerInputCharacter == 4){
                System.out.println("Keluar dari permainan");
                break;
            }
        }
    }
    public static Character getSelectCharacter(){
        return selectedCharacter;
    }

    public static void setSelectedCharacter(Character Character) {
    if(Character instanceof Draven){
        selectedCharacter = new Draven("Draven", 85, 30, 0, true, 85);
    } else if(Character instanceof Lyra){
        selectedCharacter = new Lyra("Lyra", 90, 25, 0, 0, true, 90);
    } else if(Character instanceof Kaelion){
        selectedCharacter = new Kaelion("Kaelion", 110, 20, 0, 0, true, 110);
    }
    }
}