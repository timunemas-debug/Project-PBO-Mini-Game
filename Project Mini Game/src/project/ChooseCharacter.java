package project;

import java.util.Scanner;

public class ChooseCharacter {
    private Scanner input = new Scanner(System.in);

    private Draven draven = new Draven("Draven", 85, 30, 0, 0, false, 85);
    private Lyra lyra = new Lyra("Lyra", 90, 25, 0, 0, false, 90);
    private Kaelion kaelion = new Kaelion("Kaelion", 110, 20, 0, 0, false, 110);
    private Character selectedCharacter;

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
    public Character getSelectCharacter(){
        return selectedCharacter;
  }
}