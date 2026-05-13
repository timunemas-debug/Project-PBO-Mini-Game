package com.gui.model.CharacterMiniGame;


public class Item {
    private String name, type;
    private int plusPower;

    public Item(String name, String type, int plusPower){
        this.name = name;
        this.type = type;
        this.plusPower = plusPower;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getPlusPower() {
        return plusPower;
    }

    public void getInfo(){
        System.out.println("---------------------------------");
        System.out.println("Anda mendapatkan item : " + getName());
        System.out.println("Dengan type : " + getType());
        System.out.println("Plus Power : " + getPlusPower());
        System.out.println("---------------------------------");
    }
}