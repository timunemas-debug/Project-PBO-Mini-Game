package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // HEROOOO
        Draven draven = new Draven("Draven", 85, 30, 0, 0, false, 85);
        Lyra lyra = new Lyra("Lyra", 90, 25, 0, 0, false, 90);
        Kaelion kaelion = new Kaelion("Kaelion", 110, 20, 0, 0, false, 110);

        // ENEMY
        Goblin goblin = new Goblin("Goblin", 20, 10, false);

        // DISPLAY PERMAINAN
        DisplayMenu  display = new DisplayMenu();
        display.start();

        
        // Scanner input = new Scanner(System.in);
        // int playerCoin = 20;
        // Inventory inven = new Inventory();
        // Shop toko = new Shop();
        
        // Item sword = new Item("Sword", 10);
        // Item deffend = new Item("Perisai", 10);
        // toko.addItem(sword);
        // toko.addItem(deffend);
        // toko.showItemShop();
        // System.out.print("Membeli item nomer: ");
        // int pilih = input.nextInt();
        // if(pilih == 1){
        //     toko.buyItem(sword, inven, playerCoin);
        // }
        // else if(pilih == 2){
        //     toko.buyItem(deffend, inven, playerCoin);
        // }else{
        //     System.out.println("Item tidak ditemukan!");
        // }
        // System.out.println();
        
        // inven.inventoryPlayer();
        // inven.hasItem(sword);
        // inven.hasItem(deffend);
    }
}
