package com.gui.model.CharacterMiniGame;

import java.util.function.Consumer;

import com.gui.model.CharacterMiniGame.Character.DisplayPlayer;
import com.gui.model.CharacterMiniGame.Character.Heal;
import com.gui.model.CharacterMiniGame.Character.GetChest;


import com.gui.service.Reward;

public class Draven extends Character implements Heal, GetChest, DisplayPlayer{
    private double maxHp;
    private int level;
    private Consumer<String> onLog;
    private String weapon,armor,skill;
    public Draven(String username, double hp, double attackPower, int level,boolean alive, double maxHp){
        super(username, hp, attackPower, alive);
        this.maxHp = maxHp;
        this.level = level;
    }

    public Draven(String username, double hp, double attackPower, int level,boolean alive, double maxHp, Consumer<String> onLog){
        super(username, hp, attackPower, alive);
        this.maxHp = maxHp;
        this.level = level;
        this.onLog = onLog;
    }

    public void setOnLog(Consumer<String> onLog) {
        this.onLog = onLog;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getMaxHp() {
        return maxHp;
    }
    public String getArmor() {
        return armor;
    }
    public String getSkill() {
        return skill;
    }
    public String getWeapon() {
        return weapon;
    }

    @Override
    public void setEquippedItem(Item equippedItem) {
        if(getEquippedItem() != null && getEquippedItem().getName().equalsIgnoreCase(equippedItem.getName())){
            onLog.accept("Item sudah digunakan");
            return;
        }
        super.setEquippedItem(equippedItem);
        if(equippedItem.getType().equalsIgnoreCase("Weapon")){
            weapon = equippedItem.getName();
            setAttackPower(
                getAttackPower() + getEquippedItem().getPlusPower()
            );
        }else if(equippedItem.getType().equalsIgnoreCase("Armor")){
            armor = equippedItem.getName();
            setHp(
                getHp() + getEquippedItem().getPlusPower()
            );
        }else if(equippedItem.getType().equalsIgnoreCase("Skill")){
            skill = equippedItem.getName();
            setAttackPower(
                getAttackPower() + getEquippedItem().getPlusPower()
            );
        }
    }

    @Override
    public void heal(){
        if(getHp() >= getMaxHp()){
            onLog.accept("Darah sudah tidak bisa ditambah!");
        }else{
            setHp(Math.min(getHp() + 10, getMaxHp()));
            onLog.accept(getUsername() + " Menambah Darah ");
        }
    }

    @Override
    public void attackCharacter(Character enemy){
        onLog.accept(getUsername() + " Menyerang " + enemy.getUsername());
        enemy.setHp(enemy.getHp() - getAttackPower());
        if(enemy.getHp() <= 0){
            enemy.setHp(0);
            enemy.setAlive(false);
            onLog.accept(enemy.getUsername() + " telah kalah ");
        }
    }
    
    @Override
    public void eliminasiCharacter(Character eliminasiTarget){
        if(!eliminasiTarget.isAlive()){
           onLog.accept(getUsername() + " Berhasil mengalahkan " + eliminasiTarget.getUsername());
            setLevel(getLevel() + 1);
        }else{
            onLog.accept(eliminasiTarget.getUsername() + " Masih hidup ");
        }
    }

    @Override
    public void getChestPlayer(){
        onLog.accept("Anda mendapatkan hadiah");
        Reward reward = new Reward();
        Item item = reward.getRandomItem();
        inventoryPlayer.addItem(item);
        onLog.accept("Item berhasil masuk inventory");
        item.getInfo();
    }


    @Override
    public void displayPlayer(){
        System.out.println("------------------");
        System.out.println("Nama   :" + getUsername());
        System.out.println("Level  :" + getLevel());
        System.out.println("Senjata: " + weapon);
        System.out.println("Armor  : " + armor);
        System.out.println("Skill  : " + skill);
        System.out.println("Attack :" + getAttackPower());
        System.out.println("HP     :" + getHp());
        System.out.println("------------------");
    }
}