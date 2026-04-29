package Soal1;

public class MainSoal1 {
    public static void main(String[] args) {

        // Karyawan Tetap
        KaryawanTetap tetap =
                new KaryawanTetap("Andi", "KT01",
                        5000000, 50000);

        tetap.absen();
        tetap.absen();
        tetap.absen();

        System.out.println("Gaji Karyawan Tetap + Bonus : "
                + tetap.hitungGaji(1000000));

        // Karyawan Kontrak
        KaryawanKontrak kontrak =
                new KaryawanKontrak("Budi", "KK01",
                        150000);

        for (int i = 0; i < 22; i++) {
            kontrak.absen();
        }

        System.out.println("Gaji Karyawan Kontrak : "
                + kontrak.hitungGaji());
    }
}