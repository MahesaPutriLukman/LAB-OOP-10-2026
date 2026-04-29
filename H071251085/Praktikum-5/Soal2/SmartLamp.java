package Soal2;
class SmartLamp extends PerangkatElektronik implements KontrolSuara {

SmartLamp(String merk, int dayaListrik) {
    super(merk, dayaListrik);
}

@Override
String cekFungsi() {
    return "Lampu digunakan untuk penerangan.";
}

@Override
public void prosesPerintah(String perintah) {
    if (perintah.equalsIgnoreCase("NYALA")) {
        System.out.println("\nLampu berpijar!");
    } else {
        System.out.println("Perintah tidak dikenali.");
    }
}
}

