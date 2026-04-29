public abstract class Karyawan {

    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran;

    // Constructor dengan validasi input
    public Karyawan(String nama, String idKaryawan) {

        if (nama == null || nama.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama karyawan tidak boleh kosong.");
        }

        if (idKaryawan == null || idKaryawan.trim().isEmpty()) {
            throw new IllegalArgumentException("ID karyawan tidak boleh kosong.");
        }
        this.nama = nama.trim();
        this.idKaryawan = idKaryawan.trim();
        this.jumlahKehadiran = 0;
    }

    // Method konkrit
    public void absen() {
        jumlahKehadiran++;
    }

    public String getNama() {
        return nama;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public int getJumlahKehadiran() {
        return jumlahKehadiran;
    }

    public abstract double hitungGaji();
}
