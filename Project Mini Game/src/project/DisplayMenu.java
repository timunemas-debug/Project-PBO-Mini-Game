package project;

import java.util.Scanner;

import project.Character.DisplayPlayer;

public class DisplayMenu {
    private Scanner input = new Scanner(System.in);
    
    private Inventory inventory = new Inventory();
    private ChooseCharacter choose = new ChooseCharacter();
    private Character selectedCharacter;
    Goblin goblin = new Goblin("Goblin", 20, 10, false);


    public void start(){
        System.out.println("------------------------------");
        System.out.println("SELAMAT DATANG DI MINI GAME");
        System.out.println("           MULAI           ");
        System.out.println("------------------------------");
        System.out.print("Ketik 1 jika ingin memulai! : ");
        int play = input.nextInt();
        input.nextLine();

        if(play == 1){
            displayMainMenu();
        }else{
            System.out.println("Terima kasih sudah bermain");
        }
    }
    
    public void displayMainMenu(){
        while (true) {
            System.out.println("--------------------");
            System.out.println("1. Start Game");
            System.out.println("2. Inventory");
            System.out.println("3. Shop");
            System.out.println("4. Profil");
            System.out.println("5. Keluar");
            System.out.println("--------------------");
            System.out.print("Memilih : ");
            int menu = input.nextInt();
            input.nextLine();

            if(menu == 1){
                System.out.println("Memasuki permainan....");
                choose.chooseCharacter();
                selectedCharacter = choose.getSelectCharacter();
                Pertempuran pertempuran = new Pertempuran(selectedCharacter);
                pertempuran.startPertempuran();
            }
            else if(menu == 2){
                inventory.inventoryPlayer();
            }
            else if(menu == 3){
                if(selectedCharacter != null){
                    ((DisplayPlayer) selectedCharacter).displayPlayer();
                }else{
                    System.out.println("Belum ada karakter yang dipilih");
                }
                }
            else if(menu == 5){
                System.out.println("Keluar dari game");
                break;
            }
            }
        }
}
