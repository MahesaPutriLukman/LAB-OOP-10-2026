// SmartLamp: turunan PerangkatElektronik, implementasi KontrolSuara saja
public class SmartLamp extends PerangkatElektronik implements KontrolSuara {

    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik); 
    }

    @Override
    public void cekFungsi() {
        System.out.println(getMerk() + " SmartLamp siap digunakan.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah == null || perintah.trim().isEmpty()) {
            throw new IllegalArgumentException("Perintah tidak boleh kosong.");
        }
        if (perintah.trim().equalsIgnoreCase("NYALA")) {
            System.out.println("Lampu berpijar!");
        } else {
            System.out.println("Perintah '" + perintah + "' tidak dikenali oleh SmartLamp.");
        }
    }
}
