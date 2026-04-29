package Soal2;

class SmartSpeaker extends PerangkatElektronik
        implements InteraksiInternet, KontrolSuara {

    SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    String cekFungsi() {
        return "Speaker digunakan untuk memutar audio.";
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("\nSpeaker terhubung ke WiFi.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("Memproses perintah untuk " + perintah);
    }
}