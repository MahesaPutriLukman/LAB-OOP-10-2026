public abstract class LibraryItem {

    protected String title;       
    protected int itemId;         
    protected boolean isBorrowed; 

    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false; 
    }

    // Abstract method
    public abstract String getDescription();

    public abstract String borrowItem(int days);

    public abstract double calculateFine(int daysLate);

    // Method biasa 
    public String returnItem() {
        isBorrowed = false; 
        return title + " dikembalikan";
    }

    
    public String getTitle() {
        return title;
    }

    public int getItemId() {
        return itemId;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Setter untuk mengubah status peminjaman
    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
}
