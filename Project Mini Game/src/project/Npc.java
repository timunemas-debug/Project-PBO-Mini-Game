package project;

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
}
