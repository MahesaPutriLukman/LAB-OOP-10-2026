package Tugas1;
//Subclass KaryawanTetap yang mengimplementasikan method hitungGaji dengan logika tunjangan makan
//Kelas ini mewarisi sifat dari Karyawan dengan logika gaji bulanan tetap.
public class KaryawanTetap extends Karyawan {
    private double gajiPokok;
    private double tunjanganMakan;

    public KaryawanTetap(String nama, String idKaryawan, double gajiPokok, double tunjanganMakan) {
        super(nama, idKaryawan);
        this.gajiPokok = gajiPokok;
        this.tunjanganMakan = tunjanganMakan;
    }

    // Implementasi method abstract hitungGaji
    @Override
    public double hitungGaji() {
        return gajiPokok + (tunjanganMakan * getJumlahKehadiran());
    }

    // Overloading method hitungGaji dengan parameter bonus kinerja
    public double hitungGaji(double bonusKinerja) {
        return hitungGaji() + bonusKinerja;
    }
}