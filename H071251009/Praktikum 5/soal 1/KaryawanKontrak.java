class KaryawanKontrak extends Karyawan {
    double upahPerhari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerhari) {
        super(nama, idKaryawan);
        this.upahPerhari = upahPerhari;
    }
    
    @Override
    double hitungGaji(){
        double TotalGaji = upahPerhari*getJumlahKehadiran();
        if (getJumlahKehadiran()>20){
            TotalGaji+=500000;
        }
        return TotalGaji; 
    }
}
