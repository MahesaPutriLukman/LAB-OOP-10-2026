class Book extends LibraryItem {
    String author;

    public Book(String title, int itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDescription(){
        return "Item: " + this.title + " oleh " + this.author + ", ID: " + this.itemId;
    }

    @Override
    public String borrowItem(int days){
        if(days <= 0){
            throw new IllegalArgumentException("Jumlah hari harus lebih dari 0");
        }
        
        if(days > 14){
            throw new IllegalArgumentException("Buku hanya bisa dipinjam paling lama 14 hari.");
        }

        if(this.isBorrowed){
            throw new IllegalArgumentException("Buku sudah dipinjam.");
        }

        this.isBorrowed = true;

        return "Item: " + this.title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate){
        return daysLate*10000;
    }
}