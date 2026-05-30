package com.gui.service;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DialogManager {
    
    private static class Entry {
        String pesan;
        Runnable aksi;
        
        Entry(String pesan, Runnable aksi){
            this.pesan = pesan;
            this.aksi = aksi;
        }
    }
    
    private List<Entry> pesanList = new ArrayList<>();
    private int index = 0;
    
    public void load(Consumer<Consumer<String>> sumber){
        pesanList.clear();
        index = 0;
        sumber.accept(pesan -> pesanList.add(new Entry(pesan, null)));
    }
    
    public void addWithAksi(String pesan, Runnable aksi){
        pesanList.add(new Entry(pesan, aksi));
    }
    
    public String next(){
        if(index < pesanList.size()){
            Entry entry = pesanList.get(index++);
            if(entry.aksi != null) entry.aksi.run();
            return entry.pesan;
        }
        return null;
    }
    
    public boolean isSelesai(){
        return index >= pesanList.size();
    }
}
