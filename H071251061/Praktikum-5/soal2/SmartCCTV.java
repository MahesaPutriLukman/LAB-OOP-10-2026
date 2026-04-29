package soal2;
class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {
    public SmartCCTV(String merk, int daya) { super(merk, daya); }

    @Override
    public void cekFungsi() { System.out.println("Fungsi: Keamanan Video."); }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }
}