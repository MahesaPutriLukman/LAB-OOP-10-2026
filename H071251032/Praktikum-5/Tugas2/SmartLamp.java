package Tugas2;
// Subclass SmartLamp yang mengimplementasikan method cekFungsi dan prosesPerintah
// Kelas ini mewarisi sifat dari PerangkatElektronik dan memiliki kemampuan kontrol suara.
public class SmartLamp extends PerangkatElektronik implements KontrolSuara {
    
    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void cekFungsi() {
        System.out.println("Status Lampu: Siap menerangi ruangan.");
    }

    @Override
    public void prosesPerintah(String perintah) {
        if (perintah.equalsIgnoreCase("NYALA")) {
            System.out.println("SmartLamp: Lampu berpijar!");
        } else {
            System.out.println("SmartLamp: Perintah tidak dikenal.");
        }
    }
}
