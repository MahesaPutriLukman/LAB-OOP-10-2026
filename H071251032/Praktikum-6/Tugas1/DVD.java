public class DVD extends LibraryItem {
    private int duration; // Durasi dalam menit

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration; 
    }

    @Override
    public String getDescription() {
        return "DVD: " + title + ", durasi " + duration + " menit, ID: " + itemId;
    }

    @Override
    public String borrowItem(int durasiPinjam) {
        // DVD maksimal 7 hari saja
        if (durasiPinjam > 7) {
            throw new IllegalArgumentException("Maksimal peminjaman DVD adalah 7 hari.");
        }
        
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + durasiPinjam + " hari";
    }

    @Override
    public double calculateFine(int jumlahHariTerlambat) {
        // Denda 25.000 per hari
        double totalDenda = jumlahHariTerlambat * 25000;
        return totalDenda;
    }
}