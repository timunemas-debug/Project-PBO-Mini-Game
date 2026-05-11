package com.gui.model.CharacterMiniGame.NPC;

public class Npc {
    private String nama;

    public Npc(String nama){
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void kalimatNpcGretting(){
        System.out.println("hahaha...");
        System.out.println("Hallo, kamu warga baru disini ya? hahaha");
        System.out.println("Perkenalkan saya " + getNama());
    }

    public void misiNpc(){
        System.out.println("Saya ingin meminta bantuan kamu anak muda...");
    }

    public void miniNpcMiniBos(){
        System.out.println("Apakah kamu melihat naga yang tertidur itu anak muda? ");
        System.out.println("Lawan lah dia demi saya anak muda...");
    }

    public void hadiah(){
        System.out.println("-------------------------------------------------");
        System.out.println("Gimana melawan naga itu? pasti kamu kesusahan ya.");
        System.out.println("Terimakasih ya anak muda..., ini saya kasih kamu hadiah semoga bisa membantu kamu untuk berpetualang");
        System.out.println("-------------------------------------------------");

    }
}
