package Tugas1;

// Abstract class sebagai cetakan dasar untuk semua jenis karyawan
//kelas induk yang tidak bisa dibuat objeknya secara langsung.
public abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran;

    // Constructor untuk inisialisasi nama dan ID
    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0; // Kehadiran dimulai dari 0
    }

    // Method konkrit untuk menambah kehadiran
    public void absen() {
        this.jumlahKehadiran++;
    }

    // Getter untuk mengambil nilai atribut private
    public String getNama() {
        return nama;
    }

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public int getJumlahKehadiran() {
        return jumlahKehadiran;
    }

    // Method abstract yang wajib diimplementasikan oleh subclass
    public abstract double hitungGaji();
}