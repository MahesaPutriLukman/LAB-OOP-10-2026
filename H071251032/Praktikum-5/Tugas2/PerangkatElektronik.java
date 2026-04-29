package Tugas2;
// Abstract class sebagai cetakan dasar untuk semua jenis perangkat elektronik
//kelas induk yang tidak bisa dibuat objeknya secara langsung.
public abstract class PerangkatElektronik {
    protected String merk;
    protected int dayaListrik;

    public PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }

    // Method konkrit untuk menampilkan informasi daya
    public void infoPower() {
        System.out.println("Perangkat [" + merk + "] sedang menyedot daya sebesar " + dayaListrik + " Watt.");
    }

    // Method abstract yang harus diisi oleh tiap perangkat sesuai fungsinya
    public abstract void cekFungsi();
}