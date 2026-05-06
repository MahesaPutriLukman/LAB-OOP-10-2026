public class Book extends LibraryItem {

    private String author; 

    // Constructor Book
    public Book(String title, int itemId, String author) {
        super(title, itemId); 
        this.author = author;
    }

    // Implementasi getDescription() 
    @Override
    public String getDescription() {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemId;
    }

    // Implementasi borrowItem() 
    @Override
    public String borrowItem(int days) {
        if (isBorrowed) {
            throw new IllegalArgumentException("Item sudah dipinjam dan belum dikembalikan.");
        }
        if (days > 14) {
            throw new IllegalArgumentException("Buku hanya bisa dipinjam maksimal 14 hari.");
        }
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    // Implementasi calculateFine() 
    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }

    // Method tambahan 
    public void printBooks() {
        System.out.println(getDescription());
    }

    public String getAuthor() {
        return author;
    }
}
