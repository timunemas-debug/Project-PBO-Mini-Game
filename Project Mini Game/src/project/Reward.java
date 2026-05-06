package project;

import java.util.ArrayList;
import java.util.Random;

public class Reward {
        private ArrayList<Item> reward;
    private Random random;

    public Reward(){
        this.reward = new ArrayList<>();
        this.random = new Random();

        reward.add((new Item("Pedang Api", "Weapon")));
        reward.add((new Item("Pedang Kayu", "Weapon")));
        reward.add((new Item("Pedang Besi", "Weapon")));
        reward.add((new Item("Pedang Balon", "Weapon")));
        reward.add((new Item("Armor Baja", "Armor")));
        reward.add((new Item("Armor Besi", "Armor")));
        reward.add((new Item("Kekuatan Api", "Skill")));
    }

    public Item getRandomItem(){
        int index = random.nextInt(reward.size());
        return reward.get(index);
    }
}
