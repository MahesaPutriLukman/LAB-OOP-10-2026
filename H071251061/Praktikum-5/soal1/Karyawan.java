package soal1;
abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran;

    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    public void absen() {
        this.jumlahKehadiran++;
    }

    public int getJumlahKehadiran() {
        return jumlahKehadiran;
    }

    public String getNama() {
        return nama;
    }

    public abstract double hitungGaji();
}