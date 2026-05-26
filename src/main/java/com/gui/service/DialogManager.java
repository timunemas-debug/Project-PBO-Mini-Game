package com.gui.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


public class DialogManager {
    private List<String> pesanList = new ArrayList<>();
    private int index = 0;

    public void load(Consumer<Consumer<String>> sumber){
        pesanList.clear();
        index = 0;
        sumber.accept(pesanList::add);
    }

    public String next(){
        if(index < pesanList.size()){
            return pesanList.get(index++);
        }
        return null;
    }

    public boolean isSelesai(){
        return index >= pesanList.size();
    }
}
