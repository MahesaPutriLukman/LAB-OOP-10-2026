package soal2;
class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {
    public SmartSpeaker(String merk, int daya) { super(merk, daya); }

    @Override
    public void cekFungsi() { System.out.println("Fungsi: Asisten Suara & Audio."); }

    @Override
    public void hubungkanWiFi() { System.out.println("SmartSpeaker terhubung ke cloud."); }

    @Override
    public void prosesPerintah(String perintah) {
        System.out.println("SmartSpeaker memproses perintah: " + perintah);
    }
}