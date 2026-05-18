package com.gui.service;

import java.util.ArrayList;
import java.util.Random;

import com.gui.model.CharacterMiniGame.Item;

public class Reward {
    private ArrayList<Item> reward;
    private Random random;

    public Reward(){
        this.reward = new ArrayList<>();
        this.random = new Random();

        reward.add((new Item("Pedang Api", "Weapon", 30)));
        reward.add((new Item("Pedang Kayu", "Weapon", 5)));
        reward.add((new Item("Pedang Besi", "Weapon", 15)));
        reward.add((new Item("Pedang Balon", "Weapon", 1)));
        reward.add((new Item("Armor Baja", "Armor", 20)));
        reward.add((new Item("Armor Besi", "Armor", 10)));
        reward.add((new Item("Kekuatan Api", "Skill", 50)));
    }

    public Item getRandomItem(){
        int index = random.nextInt(reward.size());
        return reward.get(index);
    }
}
