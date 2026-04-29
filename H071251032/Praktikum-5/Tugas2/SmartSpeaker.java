package Tugas2;
// Subclass SmartSpeaker yang mengimplementasikan method cekFungsi, hubungkanWiFi, dan prosesPerintah
// Kelas ini mewarisi sifat dari PerangkatElektronik dan memiliki kemampuan untuk terhub

public class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {

    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Status Speaker: Menunggu perintah atau memutar musik.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("SmartSpeaker: WiFi aktif. Siap melakukan streaming.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("SmartSpeaker: Memproses perintah suara '" + perintah + "'.");
    }
}
