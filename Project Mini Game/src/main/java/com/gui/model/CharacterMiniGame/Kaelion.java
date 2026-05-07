package com.gui.model.CharacterMiniGame;

import com.gui.service.Reward;
import com.gui.model.CharacterMiniGame.Character.DisplayPlayer;
import com.gui.model.CharacterMiniGame.Character.GetChest;
import com.gui.model.CharacterMiniGame.Character.Heal;
public class Kaelion extends Character implements Heal, GetChest, DisplayPlayer{
    private double coin, maxHp;
    private int level;
    public Kaelion(String username, double hp, double attackPower, double coin, int level,boolean alive, double maxHp){
        super(username, hp, attackPower,alive);
        this.maxHp = maxHp;
        this.coin = coin;
        this.level = level;
    }

    public double getCoin() {
        return coin;
    }
    
    public void setCoin(double coin) {
        this.coin = coin;
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
    

    @Override
    public void heal(){
        if(getHp() >= getMaxHp()){
            System.out.println("Darah sudah tidak bisa ditambah!");
        }else{
            setHp(getHp() + 10);
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
            System.out.println(enemy.getUsername() + " telah kalah");
        }
    }
    
    @Override
    public void eliminasiCharacter(Character eliminasiTarget){
        if(!eliminasiTarget.isAlive()){
            System.out.println(getUsername() + " Berhasil mengalahkan " + eliminasiTarget.getUsername());
            setCoin(getCoin() + 5);
            setLevel(getLevel() + 1);
            System.out.println("Anda mendapatkan coin sebesar 5 Coin");
        }else{
            System.out.println(eliminasiTarget.getUsername() + "Masih hidup");
        }
    }

    @Override
    public void getChest(){
        System.out.println("Selamat anda mendapatkan Chest!");
        Reward reward = new Reward();
        reward.getRandomItem();
    }

    @Override
    public void displayPlayer(){
        System.out.println("------------------");
        System.out.println("Nama   :" + getUsername());
        System.out.println("Level  :" + getLevel());
        System.out.println("Senjata: ");
        System.out.println("Armor  : ");
        System.out.println("Skill  : ");
        System.out.println("Attack :" + getAttackPower());
        System.out.println("HP     :" + getHp());
        System.out.println("------------------");
    }
}
