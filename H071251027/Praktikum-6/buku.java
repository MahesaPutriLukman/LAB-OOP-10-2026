public class buku extends BarangPerpus{
    // atribut tambahan untuk menyimpan nama author
    String author;

    // constructor untuk mengisi judul, ID, dan author
    public buku(String judul, int ID, String author) {
        super(judul, ID); // memanggil constructor dari class induk
        this.author = author;
    }

    @Override
    String getDescription(){
        // menampilkan deskripsi buku
        return "Buku : " + judul + " oleh author : " + author + ", ID : " + ID;
    }

    @Override
    String pinjamBarang(int Days){
        // cek jika hari peminjaman lebih dari 14
        if (Days > 14){
            throw new IllegalArgumentException("Maksimal peminjaman 14 hari.");
        } 
        
        // cek jika buku sudah dipinjam
        if (pinjaman) {
            throw new IllegalArgumentException("item telah dipinjam dan belum dikembalikan.");
        } 
        
        // ubah status menjadi dipinjam (method dari kelas induk)
        super.BarangDipinjam();
        // mengembalikan informasi bahwa buku dipinjam
        return getDescription() + " dipinjam.";
    }

    @Override
    double tenggatWaktu(int DaysLate){
        // menghitung denda keterlambatan
        double denda = DaysLate * 10000;
        return denda;
    }

}