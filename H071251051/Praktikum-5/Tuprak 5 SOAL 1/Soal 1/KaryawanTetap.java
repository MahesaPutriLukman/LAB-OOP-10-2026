public class KaryawanTetap extends Karyawan {

    private double gajiPokok;
    private double tunjanganMakan;

    // Constructor dengan validasi input
    public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan) {
        super(nama, idKaryawan);
        // Validasi: gaji pokok 
        if (gajiPokok <= 0) {
            throw new IllegalArgumentException("Gaji pokok harus lebih dari 0.");
        }
        // Validasi: tunjangan makan 
        if (tunjanganMakan < 0) {
            throw new IllegalArgumentException("Tunjangan makan tidak boleh negatif.");
        }
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    // hitungGaji
    @Override
    public double hitungGaji() {
        return gajiPokok + (tunjanganMakan * getJumlahKehadiran());
    }

    // Overloading: hitungGaji dengan parameter bonusKinerja
    public double hitungGaji(double bonusKinerja) {
        // Validasi: bonus kinerja 
        if (bonusKinerja < 0) {
            throw new IllegalArgumentException("Bonus kinerja tidak boleh negatif.");
        }
        return hitungGaji() + bonusKinerja;
    }
}
