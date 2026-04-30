package project;

import java.util.ArrayList;
import java.util.Random;

public class Item {
    private String name, type;

    public Item(String name, String type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void getInfo(){
        System.out.println("Anda mendapatkan item : " + getName());
        System.out.println("Dengan type : " + getType());
    }
}

class RewardPool {
    private ArrayList<Item> reward;
    private Random random;

    public RewardPool(){
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
