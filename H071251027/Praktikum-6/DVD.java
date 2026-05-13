public class DVD extends BarangPerpus{
    // atribut tambahan untuk menyimpan durasi DVD dalam menit
    int durasi;

    // Konstruktor kelas anak 
    public DVD(String judul, int ID, int durasi) {
        super(judul, ID); // memanggil constructor dari parent class
        this.durasi = durasi; // mengisi nilai durasi
    }

    @Override
    String getDescription(){
        // mengembalikan deskripsi DVD
        return "DVD : " + judul + " durasi : " + durasi + " menit, ID : " + ID;
    }

    @Override
    String pinjamBarang(int Days){
        // cek jika hari peminjaman lebih dari 7 hari
        if (Days > 7){
            throw new IllegalArgumentException("Maksimal peminjaman 7 hari.");
        } 
        // cek jika DVD sudah dipinjam
        if (pinjaman) {
            throw new IllegalArgumentException("item telah dipinjam dan belum dikembalikan.");
        }
        // ubah status menjadi dipinjam (method dari kelas induk)
        super.BarangDipinjam();

        // mengembalikan informasi bahwa DVD dipinjam
        return getDescription() + " dipinjam.";
    }

    @Override
    double tenggatWaktu(int DaysLate){
        // menghitung denda keterlambatan (25000 per hari)
        double denda = DaysLate * 25000;
        return denda;
    }

}