package Soal2;

public class SmartLamp extends PerangkatElektronik
        implements KontrolSuara {

    public SmartLamp(String merk, int daya) {
        super(merk, daya);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Lampu siap digunakan");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        }
    }
}