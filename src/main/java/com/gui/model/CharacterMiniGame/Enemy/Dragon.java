package com.gui.model.CharacterMiniGame.Enemy;

import com.gui.model.CharacterMiniGame.Character;
import com.gui.model.CharacterMiniGame.Character.DisplayPlayer;
import com.gui.service.Reward;

public class Dragon extends Character implements DisplayPlayer{
    public Dragon(String username, double hp, double attackPower, boolean alive){
        super(username, hp, attackPower, alive);
    }

    @Override
    public void attackCharacter(Character enemy){
        System.out.println(getUsername() + " Menyerang " + enemy.getUsername());
        enemy.setHp(enemy.getHp() - getAttackPower());
        if(enemy.getHp() <= 0){
            enemy.setHp(0);
            enemy.setAlive(false);
            System.out.println(enemy.getUsername() + " telah kalah");
            Reward rewardPool = new Reward();
            rewardPool.getRandomItem();
        }
    }

    @Override
    public void eliminasiCharacter(Character eliminasiTarget){
        if(!eliminasiTarget.isAlive()){
            System.out.println(getUsername() + " Berhasil mengalahkan " + eliminasiTarget.getUsername());
        }else{
            System.out.println(eliminasiTarget.getUsername() + "Masih hidup");
        }
    }

    @Override
    public void displayPlayer(){
        System.out.println("Nama : Dragon");
        System.out.println("Hp   : " + getHp());
    }
}
