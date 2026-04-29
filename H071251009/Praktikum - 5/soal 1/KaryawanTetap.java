class KaryawanTetap extends Karyawan {
    double gajiPokok;
    double tunjanganMakan;
    public KaryawanTetap(String nama, String idKaryawan, int gajiPokok, int tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }
   

    @Override
    double hitungGaji() {
        double totalGaji = gajiPokok + (tunjanganMakan*getJumlahKehadiran());
        return totalGaji;
    }

    double hitungGaji (double bonusKinerja){
        return hitungGaji() + bonusKinerja;
    }
}

