package com.gui.model.CharacterMiniGame;

public class Item {
    private String name, type;

    public Item(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void getInfo(){
        System.out.println("---------------------------------");
        System.out.println("Anda mendapatkan item : " + getName());
        System.out.println("Dengan type : " + getType());
        System.out.println("---------------------------------");
    }
}