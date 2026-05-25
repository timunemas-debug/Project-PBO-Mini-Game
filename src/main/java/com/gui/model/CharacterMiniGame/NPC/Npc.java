package com.gui.model.CharacterMiniGame.NPC;

import java.util.function.Consumer;

public class Npc {
    private String nama;
    private Consumer<String> onLog;

    public Npc(String nama){
        this.nama = nama;
    }

    public Npc(String nama, Consumer<String> onlog){
        this.nama = nama;
        this.onLog = onlog;
    }

    public String getNama() {
        return nama;
    }

    public void kalimatNpcGretting(){
        onLog.accept("hahaha...");
        onLog.accept("Hallo, kamu warga baru disini ya? hahaha");
        onLog.accept("Perkenalkan saya " + getNama());
    }

    public void misiNpc(){
        onLog.accept("Saya ingin meminta bantuan kamu anak muda...");
    }

    public void miniNpcMiniBos(){
        onLog.accept("Apakah kamu melihat naga yang tertidur itu anak muda? ");
        onLog.accept("Lawan lah dia demi saya anak muda...");
    }

    public void hadiah(){
        onLog.accept("-------------------------------------------------");
        onLog.accept("Gimana melawan naga itu? pasti kamu kesusahan ya.");
        onLog.accept("Terimakasih ya anak muda..., ini saya kasih kamu hadiah semoga bisa membantu kamu untuk berpetualang");
        onLog.accept("-------------------------------------------------");

    }
}
