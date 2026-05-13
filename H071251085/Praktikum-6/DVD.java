class DVD extends LibraryItem{
    String duration;

    DVD (String title, int itemID, String duration){
        super(title, itemID);
        this.duration = duration;
    }

    String getDescription () {
        return "DVD: " + title + " oleh " + duration + " menit, ID: " + itemID;
    }

    String borrowItem (int days) {
        if (days > 7){
            throw new IllegalArgumentException ("Peminajaman maksimal 7 hari");
        } else if (isBorrowed){
            throw new IllegalArgumentException ("Item sudah dipinjam dan belum dikembalikan");
        }
        isBorrowed = true;
        return "DVD " + title + " berhasil dipinjam selama " + days + " hari";
    }

    Double calculateFine (int daysLate){
        Double calculate = 25000.0 * daysLate;
        return calculate;
    }
}
