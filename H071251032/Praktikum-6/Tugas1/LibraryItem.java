
public abstract class LibraryItem {
    // Variabel dilindungi (protected) agar bisa dipakai kelas anak
    protected String title;
    protected int itemId;
    // Variabel ini untuk menandai apakah barang sedang dipinjam atau tidak
    protected boolean isBorrowed;

    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false; // Awalnya barang pasti tersedia
    }

    // Method ini wajib ada di Buku dan DVD tapi isinya beda-beda
    //method ini digunakan untuk menampilkan deskripsi barang, seperti penulis untuk buku atau durasi untuk DVD
    public abstract String getDescription();
    //method ini digunakan untuk meminjam barang, dengan parameter jumlah hari peminjaman
    public abstract String borrowItem(int days);
    //method ini digunakan untuk menghitung denda jika barang terlambat dikembalikan, dengan parameter jumlah hari keterlambatan
    public abstract double calculateFine(int daysLate);

    // Method untuk mengembalikan barang
    public String returnItem() {
        this.isBorrowed = false; // Status berubah jadi tersedia
        return title + " dikembalikan";
    }

    // Getter untuk membantu mengambil data dari luar kelas
    public int getItemId() { return itemId; }
    public String getTitle() { return title; }
    public boolean getIsBorrowed() { return isBorrowed; }
}