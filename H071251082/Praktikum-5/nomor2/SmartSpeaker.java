package nomor2;

class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {
    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi(){
        System.out.println("Fungsi: Pusat kontrol dan pemutar media.");
    }

    @Override
    public void hubungkanWiFi(){
        System.out.println("Smart Speaker berhasil terhubung dengan jaringan WiFi.");
    }

    @Override
    public void prosesPerintah(String perintah){
        System.out.println("Memproses perintah: " + perintah);
    }
}
