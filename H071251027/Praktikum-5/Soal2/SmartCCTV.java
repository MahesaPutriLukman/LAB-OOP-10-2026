package Soal2;

public class SmartCCTV extends PerangkatElektronik
        implements InteraksiInternet {

    public SmartCCTV(String merk, int daya) {
        super(merk, daya);
    }

    @Override
    public void cekFungsi() {
        System.out.println("CCTV aktif");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }
}