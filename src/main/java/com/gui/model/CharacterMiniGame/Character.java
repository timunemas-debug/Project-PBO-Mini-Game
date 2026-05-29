package com.gui.model.CharacterMiniGame;

import com.gui.service.Inventory;
public abstract class Character {
    private String username;
    private double hp, attackPower;
    private boolean alive;
    private Item equippedItem;

    protected Inventory inventoryPlayer;

    public Character(String username, double hp, double attackPower,boolean alive){
        this.username = username;
        this.hp = hp;
        this.attackPower = attackPower;
        this.alive = alive;

        inventoryPlayer = new Inventory(this);
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(double attackPower) {
        this.attackPower = attackPower;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public Item getEquippedItem() {
        return equippedItem;
    }

    public void setEquippedItem(Item equippedItem) {
        this.equippedItem = equippedItem;
    }

    public boolean isAlive(){
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Inventory getInventoryPlayer() {
        return inventoryPlayer;
    }
    
    public interface Heal{
        void heal();
    }
    
    public interface DisplayPlayer {
        void displayPlayer();
    }
    
    public interface GetChest {
        void getChestPlayer();
    }

    public abstract void attackCharacter(Character enemy);

    public abstract void eliminasiCharacter(Character eliminasiTarget);

}
