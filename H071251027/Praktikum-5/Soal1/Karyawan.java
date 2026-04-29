package Soal1;

public abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    protected int jumlahKehadiran;

    public Karyawan(String nama, String idKaryawan) {
        this.nama = nama;
        this.idKaryawan = idKaryawan;
        this.jumlahKehadiran = 0;
    }

    public void absen() {
        jumlahKehadiran++;
    }

    public abstract double hitungGaji();
}