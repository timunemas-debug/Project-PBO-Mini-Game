package project.Enemy;

import project.CharacterMiniGame.Character;

public class Goblin extends Character{
    public Goblin(String username, double hp, double attackPower, boolean alive){
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
}
