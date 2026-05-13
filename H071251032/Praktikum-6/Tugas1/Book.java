public class Book extends LibraryItem {
    private String author; // Nama penulis buku

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    @Override
    public String borrowItem(int durasiPinjam) {
        // Cek kalau pinjam lebih dari 14 hari
        if (durasiPinjam > 14) {
            throw new IllegalArgumentException("Maksimal peminjaman buku adalah 14 hari.");
        }
        
        // Cek kalau barangnya sudah dipinjam orang lain
        if (isBorrowed == true) {
            throw new IllegalArgumentException("Item telah dipinjam dan belum dikembalikan.");
        }

        isBorrowed = true; // Tandai barang sudah dibawa
        return "Item " + title + " berhasil dipinjam selama " + durasiPinjam + " hari";
    }

    @Override
    public double calculateFine(int jumlahHariTerlambat) {
        // Denda 10.000 per hari
        double totalDenda = jumlahHariTerlambat * 10000;
        return totalDenda;
    }
}