package com.project;

public abstract class Character {
    private String username;
    private double hp, attackPower;
    private boolean alive;

    public Character(String username, double hp, double attackPower,boolean alive){
        this.username = username;
        this.hp = hp;
        this.attackPower = attackPower;
        this.alive = alive;
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

    public boolean isAlive(){
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void displayCharacter(){
        System.out.println("------------------");
        System.out.println("Nama   :" + getUsername());
        System.out.println("Attack :" + getAttackPower());
        System.out.println("HP     :" + getHp());
        System.out.println("------------------");
    }

    
    public interface Heal{
        void heal();
    }
    
    public interface GetChest{
        void getChest();
    }
    
    abstract void attackCharacter(Character enemy);

    abstract void eliminasiCharacter(Character eliminasiTarget);
}
