abstract class BarangPerpus {
      // Atribut
    protected String judul;
    protected int ID;
    protected boolean pinjaman;
     // Constructor untuk mengisi data awal
    public BarangPerpus(String judul, int ID) {
        this.judul = judul;
        this.ID = ID;
        this.pinjaman = false;
    }
    // Method abstract untuk deskripsi item
    abstract String getDescription();
    // Method abstract untuk proses peminjaman
    abstract String pinjamBarang(int Days);
    // Method abstract untuk menghitung denda
    abstract double tenggatWaktu(int DaysLate);

    // Method untuk mengembalikan barang
    public String BarangKembali(){
        this.pinjaman = false;
        return judul + " dikembalikan.";
    }

    // Method tambahan untuk menandai barang sedang dipinjam
    public String BarangDipinjam(){
        this.pinjaman = true;
        return judul + "dipinjam.";
    }
}