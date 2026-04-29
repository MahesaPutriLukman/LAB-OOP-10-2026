package Soal2;

public class SmartSpeaker extends PerangkatElektronik
        implements InteraksiInternet, KontrolSuara {

    public SmartSpeaker(String merk, int daya) {
        super(merk, daya);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Speaker pintar siap");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Speaker terhubung WiFi");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Memproses perintah: " + perintah);
    }
}