package Soal1;
abstract class Karyawan {
    private String nama;
    private String idKaryawan;
    private int jumlahKehadiran = 0;

    public int getjumlahKehadiran (){
        return jumlahKehadiran;
    }

    public String getnama (){
        return nama;
    }

    public String getIdKaryawan(){
        return idKaryawan;
    }

    public Karyawan (String nama, String idKaryawan){
        this.nama = nama;
        this.idKaryawan = idKaryawan;
    }

    void absen (){
        jumlahKehadiran++;
    }

    abstract int hitungGaji ();
}