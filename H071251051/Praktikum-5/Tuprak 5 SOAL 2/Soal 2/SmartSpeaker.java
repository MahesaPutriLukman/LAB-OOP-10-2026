// SmartSpeaker: turunan PerangkatElektronik, implementasi KEDUA interface
public class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet, KontrolSuara {

    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik); // validasi merk & daya ada di PerangkatElektronik
    }

    @Override
    public void cekFungsi() {
        System.out.println(getMerk() + " SmartSpeaker siap memutar audio.");
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("Mengirim data ke server...");
    }

    @Override
    public void prosesPerintah(String perintah) {

        if (perintah == null || perintah.trim().isEmpty()) {
            throw new IllegalArgumentException("Perintah tidak boleh kosong.");
        }
        if (perintah.trim().equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        } else {
            System.out.println("Perintah '" + perintah + "' tidak dikenali oleh SmartSpeaker.");
        }
    }
}
