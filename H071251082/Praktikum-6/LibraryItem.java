abstract class LibraryItem{
    String title;
    int itemId;
    boolean isBorrowed;

    public LibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    public abstract String getDescription();
    public abstract String borrowItem(int days);
    public abstract double calculateFine(int daysLate);

    public String returnItem(){
        this.isBorrowed = false;
        return this.title + " telah dikembalikan";
    }
}