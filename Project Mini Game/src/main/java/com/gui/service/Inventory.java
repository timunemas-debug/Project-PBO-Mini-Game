package com.gui.service;

import com.gui.model.CharacterMiniGame.Character;

import java.util.ArrayList;
import java.util.Scanner;

import com.gui.model.CharacterMiniGame.Item;

public class Inventory{
    private ArrayList<Item> items = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private Character player;

    public Inventory(Character player){
        this.player = player;
    }

    public Character getPlayer() {
        return player;
    }

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public boolean hasItem(Item item){
        return items.contains(item);
    }

    public void inventoryPlayer(){
        System.out.println("Inventory");
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            System.out.println((i+1) + ". " + item.getName());
        }
    }

    public Item useItem(int choise){
        int index = choise - 1;
        if(index < 0 || index >= items.size()){
            System.out.println("item tidak ditemukan");
            return null;
        }
        Item item = items.get(index);
        System.out.println("Anda menggunakan : " + item.getName());
        player.setEquippedItem(item);
        return item;
    }

    public Item useItemPlayer(){
        player.getInventoryPlayer().inventoryPlayer();
        System.out.print("Anda ingin menggunakan Item nomer berapa? : ");
        int userItem = input.nextInt();
        input.nextLine();
        return player.getInventoryPlayer().useItem(userItem);
    }
}