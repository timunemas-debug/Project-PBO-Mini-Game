package project;

import java.util.ArrayList;

public class Inventory{
    private ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }

    public boolean hasItem(Item item){
        return items.contains(item);
    }

    public void inventoryPlayer(){
        System.out.println("Inventory");
        for(int i = 0; i < items.size(); i++){
            Item item = items.get(i);
            System.out.println((i+1) + ". " + item.getName());
        }
    }
}
