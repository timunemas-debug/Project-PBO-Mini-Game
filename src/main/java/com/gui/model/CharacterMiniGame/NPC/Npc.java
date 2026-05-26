package com.gui.model.CharacterMiniGame.NPC;

import java.util.function.Consumer;

public class Npc {
    private String nama;

    public Npc(String nama){
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void kalimatNpcGretting(Consumer<String> onLog){
        onLog.accept("hahaha...");
        onLog.accept("Hallo, kamu warga baru disini ya? hahaha");
        onLog.accept("Perkenalkan saya " + getNama());
    }

    public void misiNpc(Consumer<String> onLog){
        onLog.accept("Saya ingin meminta bantuan kamu anak muda...");
    }

    public void misiNpcMiniBos(Consumer<String> onLog){
        onLog.accept("Apakah kamu melihat naga yang tertidur itu anak muda? ");
        onLog.accept("Lawan lah dia demi saya anak muda...");
    }

    public void hadiah(Consumer<String> onLog){
        onLog.accept("-------------------------------------------------");
        onLog.accept("Gimana melawan naga itu? pasti kamu kesusahan ya.");
        onLog.accept("Terimakasih ya anak muda..., ini saya kasih kamu hadiah semoga bisa membantu kamu untuk berpetualang");
        onLog.accept("-------------------------------------------------");

    }
}
