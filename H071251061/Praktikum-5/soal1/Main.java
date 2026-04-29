package soal1;
public class Main {
    public static void main(String[] args) {
        KaryawanTetap tetap = new KaryawanTetap("Owo", "T001", 5000000, 50000);
        for (int i = 0; i < 22; i++) tetap.absen();
        System.out.println("Gaji Karyawan Tetap (" + tetap.getNama() + ") + Bonus: Rp" + tetap.hitungGaji(1000000));

        KaryawanKontrak kontrak = new KaryawanKontrak("Owi", "K001", 150000);
        for (int i = 0; i < 25; i++) kontrak.absen();
        System.out.println("Gaji Karyawan Kontrak (" + kontrak.getNama() + "): Rp" + kontrak.hitungGaji());
    }
}