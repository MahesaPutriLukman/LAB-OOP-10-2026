package Tugas2;
// Subclass SmartCCTV yang mengimplementasikan method cekFungsi dan hubungkanWiFi
// Kelas ini mewarisi sifat dari PerangkatElektronik dan memiliki kemampuan untuk terhub
public class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {

    public SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Status CCTV: Sedang memantau keamanan.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("SmartCCTV: Terhubung ke WiFi. Mengirim data ke server...");
    }
}
