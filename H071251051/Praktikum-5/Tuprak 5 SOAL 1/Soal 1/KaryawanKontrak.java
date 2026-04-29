public class KaryawanKontrak extends Karyawan {

    private double upahPerHari;

    public KaryawanKontrak(String nama, String idKaryawan, double upahPerHari) {
        super(nama, idKaryawan);
        // Validasi: upah per hari
        if (upahPerHari <= 0) {
            throw new IllegalArgumentException("Upah per hari harus lebih dari 0.");
        }
        this.upahPerHari = upahPerHari;
    }

    // hitungGaji() dengan validasi bonus jika hadir lebih dari 20 hari
    @Override
    public double hitungGaji() {
        double totalGaji = upahPerHari * getJumlahKehadiran();

        if (getJumlahKehadiran() > 20) {
            totalGaji += 500000; 
        }

        return totalGaji;
    }
}
