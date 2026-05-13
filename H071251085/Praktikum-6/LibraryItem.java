abstract class LibraryItem {
    String title;
    int itemID;
    Boolean isBorrowed;

    LibraryItem (String title, int itemID){
        this.title = title;
        this.itemID = itemID;
        this.isBorrowed = false; 
    }

    abstract String getDescription();

    abstract String borrowItem(int days);

    abstract Double calculateFine (int daysLate);

    String returnItem(){
        isBorrowed = false;
        return title + "dikembalikan";
    }
}