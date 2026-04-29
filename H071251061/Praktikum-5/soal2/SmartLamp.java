package soal2;
class SmartLamp extends PerangkatElektronik implements KontrolSuara {
    public SmartLamp(String merk, int daya) { super(merk, daya); }

    @Override
    public void cekFungsi() { System.out.println("Fungsi: Pencahayaan Pintar."); }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        }
    }
}
