package com.gui.model.CharacterMiniGame;

import com.gui.model.CharacterMiniGame.Character.DisplayPlayer;
import com.gui.model.CharacterMiniGame.Character.Heal;
import com.gui.model.CharacterMiniGame.Character.GetChest;

import com.gui.service.Reward;

public class Draven extends Character implements Heal, GetChest, DisplayPlayer{
    private double maxHp;
    private int level;
    private String weapon,armor,skill;
    public Draven(String username, double hp, double attackPower, int level,boolean alive, double maxHp){
        super(username, hp, attackPower, alive);
        this.maxHp = maxHp;
        this.level = level;
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
            System.out.println("Item sudah digunakan");
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
            System.out.println("Darah sudah tidak bisa ditambah!");
        }else{
            setHp(Math.min(getHp() + 10, getMaxHp()));
            System.out.println(getUsername() + " Menambah Darah ");
        }
    }

    @Override
    public void attackCharacter(Character enemy){
        System.out.println(getUsername() + " Menyerang " + enemy.getUsername());
        enemy.setHp(enemy.getHp() - getAttackPower());
        if(enemy.getHp() <= 0){
            enemy.setHp(0);
            enemy.setAlive(false);
            System.out.println(enemy.getUsername() + " telah kalah ");
        }
    }
    
    @Override
    public void eliminasiCharacter(Character eliminasiTarget){
        if(!eliminasiTarget.isAlive()){
            System.out.println(getUsername() + " Berhasil mengalahkan " + eliminasiTarget.getUsername());
            setLevel(getLevel() + 1);
        }else{
            System.out.println(eliminasiTarget.getUsername() + " Masih hidup ");
        }
    }

    @Override
    public void getChestPlayer(){
        System.out.println("Anda mendapatkan hadiah");
        Reward reward = new Reward();
        Item item = reward.getRandomItem();
        inventoryPlayer.addItem(item);
        System.out.println("Item berhasil masuk inventory");
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