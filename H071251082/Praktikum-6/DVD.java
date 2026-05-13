 class DVD extends LibraryItem{
    int duration;

    public DVD(String title, int itemId, int duration) {
        super(title, itemId);
        this.duration = duration;
    }

    @Override
    public String getDescription(){
        return "Item: " + this.title + " durasi " + this.duration + " menit, ID: " + this.itemId;
    }

    @Override
    public String borrowItem(int days){
        if(days <= 0){
            throw new IllegalArgumentException("Jumlah hari harus lebih dari 0.");
        }

        if(days > 7){
            throw new IllegalArgumentException("DVD hanya bisa dipinjam paling lama 7 hari.");
        }

        if(this.isBorrowed){
            throw new IllegalArgumentException("DVD sudah dipinjam.");
        }

        this.isBorrowed = true;

        return "Item: " + this.title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate){
        return daysLate*25000;
    }
}
