class Book extends LibraryItem{
    String author;

    Book (String title, int itemID, String author){
        super(title, itemID);
        this.author = author;
    }

    
    String getDescription () {
        return "Buku: " + title + " oleh " + author + ", ID: " + itemID;
    }

    String borrowItem (int days) {
        if (days > 14){
            throw new IllegalArgumentException ("Peminajaman maksimal 14 hari");
        } else if (isBorrowed){
            throw new IllegalArgumentException ("Item sudah dipinjam dan belum dikembalikan");
        }
        isBorrowed = true;
        return "Buku " + title + " berhasil dipinjam selama " + days + " hari";
    }

    Double calculateFine (int daysLate){
        Double calculate = 10000.0 * daysLate;
        return calculate;
    }
}
