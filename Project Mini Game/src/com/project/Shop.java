package com.project;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Item> itemsForeSale = new ArrayList<>();

    public void addItem(Item item){
        itemsForeSale.add(item);
    }

    public void showItemShop(){
        System.out.println("-----------SHOP----------");
        for(int i = 0; i < itemsForeSale.size(); i++){
            Item item = itemsForeSale.get(i);
            System.out.println((i+1) + ". " + item.getName() + " - " + item.getPrice());
        }
    }

    public void buyItem(Item item, Inventory playerInventory, double playerCoin){
        if(itemsForeSale.contains(item)){
            if(playerCoin >= item.getPrice()){
                playerInventory.addItem(item);
                System.out.println("Berhasil dibeli!. " + item.getName());
            }else{
                System.out.println("Coin tidak cukup!");
            }
        }else{
            System.out.println("Item tidak tersedia di shop!");
        }
    }
}
