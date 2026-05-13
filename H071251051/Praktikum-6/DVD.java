public class DVD extends LibraryItem {

    private int duration; 

    // Constructor DVD
    public DVD(String title, int itemId, int duration) {
        super(title, itemId); 
        this.duration = duration;
    }

    // Implementasi getDescription()
    @Override
    public String getDescription() {
        return "DVD: " + title + ", durasi " + duration + " menit, ID: " + itemId;
    }

    // Implementasi borrowItem() 
    @Override
    public String borrowItem(int days) {
        if (days > 7) {
            throw new IllegalArgumentException("DVD hanya bisa dipinjam maksimal 7 hari.");
        }
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    // Implementasi calculateFine() 
    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 25000;
    }

    public int getDuration() {
        return duration;
    }
}
