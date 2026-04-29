package nomor2;

abstract class PerangkatElektronik {
    String merk;
    int dayaListrik;

    public PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    public abstract void cekFungsi();

    public void infoPower(){
        System.out.println("Perangkat " + merk + " Menggunakan daya sebesar: " + dayaListrik + " Watt.");
    }
}
