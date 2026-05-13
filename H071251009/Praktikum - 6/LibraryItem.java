public abstract class LibraryItem {
    String title;
    int itemId;
    boolean isBorrowed;
    public LibraryItem(String title, int itemId, boolean isBorrowed) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = isBorrowed;
    }

    abstract String getDescription ();
    abstract String borrowItem (int days);
    abstract double calculateFine(int daysLate);

    public String returnItem (){
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
    
}
