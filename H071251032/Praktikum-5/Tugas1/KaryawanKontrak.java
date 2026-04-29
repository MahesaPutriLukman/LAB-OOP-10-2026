package Tugas1;
//Subclass KaryawanKontrak yang mengimplementasikan method hitungGaji dengan logika bonus
//Kelas ini mewarisi sifat dari Karyawan dengan logika gaji berdasarkan kehadiran harian.
public class KaryawanKontrak extends Karyawan {
    private double upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        this.upahPerHari = upahPerHari;
    }

    // Implementasi logika hitungGaji dengan validasi bonus
    @Override
    public double hitungGaji() {
        double totalGaji = upahPerHari * getJumlahKehadiran();
        
        // Validasi: Jika kehadiran lebih dari 20 hari, dapat bonus flat Rp500.000
        if (getJumlahKehadiran() > 20) {
            totalGaji += 500000;
        }
        
        return totalGaji;
    }
}
