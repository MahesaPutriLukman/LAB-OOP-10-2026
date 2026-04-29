public abstract class Karyawan {
  private String nama;
  private String idKaryawan;
  private int jumlahKehadiran;
  public Karyawan(String nama, String idKaryawan) {
    this.nama = nama;
    this.idKaryawan = idKaryawan;
  }
  
  void absen(){
    this.jumlahKehadiran ++ ;
  }

  abstract double hitungGaji();

  public String getNama() {
    return nama;
  }

  public String getIdKaryawan() {
    return idKaryawan;
  }

  public int getJumlahKehadiran() {
    return jumlahKehadiran;
  }

}
