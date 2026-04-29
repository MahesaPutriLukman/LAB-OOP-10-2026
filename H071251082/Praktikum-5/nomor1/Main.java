package nomor1;

public class Main {
    public static void main(String[] args) {
        KaryawanTetap karyawan1 = new KaryawanTetap("Prabowo", "RI1", 5000000, 100000);
        KaryawanKontrak karyawan2 = new KaryawanKontrak("Gibran", "RI2", 100000);

        for(int i = 0; i < 20; i++) {
            karyawan1.absen();
        }
        System.out.println("Gaji " + karyawan1.getNama() + " tanpa bonus: Rp" + karyawan1.hitungGaji());
        System.out.println("Gaji " + karyawan1.getNama() + " dengan bonus: Rp" + karyawan1.hitungGaji(1500000));
        System.out.println();

        for(int i = 0; i < 20; i++) {
            karyawan2.absen(); 
        }
        System.out.println("Gaji " + karyawan2.getNama() + " (>20 hari kehadiran): Rp" + karyawan2.hitungGaji());
    }
}
