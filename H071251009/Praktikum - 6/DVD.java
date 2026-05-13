class DVD extends LibraryItem {
    int duration;

    public DVD(String title, int itemId, boolean isBorrowed, int duration) {
        super(title, itemId, isBorrowed);
        this.duration = duration;
    }

    @Override
    String getDescription() {
       return "DVD: " + title + " durasi " + duration + " menit," + "ID: "+ itemId ;
    }

    @Override
    String borrowItem(int days) {
        if(days > 7){
            throw new IllegalArgumentException("Dapat dipinjam maksimal 7 hari");
        }
        if (isBorrowed) {
        throw new IllegalArgumentException("Item telah dipinjam");
        }
        isBorrowed = true;
        return "item "+ title + " berhasil dipinjam selama "+ days + " hari";
    }

    @Override
    double calculateFine(int daysLate) {
       return daysLate * 25000;
    }
    
}
