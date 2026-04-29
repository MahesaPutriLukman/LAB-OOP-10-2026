package Soal1;

public class KaryawanKontrak extends Karyawan {

    private double upahPerHari;

    public KaryawanKontrak(String nama, String id,
            double upahPerHari) {
        super(nama, id);
        this.upahPerHari = upahPerHari;
    }

    @Override
    public double hitungGaji() {
        double total = upahPerHari * jumlahKehadiran;

        if (jumlahKehadiran > 20) {
            total += 500000;
        }

        return total;
    }
}