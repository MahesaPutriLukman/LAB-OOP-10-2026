package Tugas1;

public class Main {
    public static void main(String[] args) {
        System.out.println("-------------------------------------------------");
        System.out.println("========== SISTEM PENGGAJIAN KARYAWAN ==========");
        System.out.println("-------------------------------------------------\n");


        // 1. Membuat objek KaryawanTetap
        KaryawanTetap kt = new KaryawanTetap("Chao Yufan", "KT-001", 5000000, 50000);
        
        // Simulasi absen 22 kali
        for (int i = 0; i < 22; i++) {
            kt.absen();
        }

        // Tampilkan hasil Karyawan Tetap
        double bonus = 1000000;
        System.out.println("===== Data Karyawan Tetap =====");
        System.out.println("ID        : " + kt.getIdKaryawan());
        System.out.println("Nama      : " + kt.getNama());
        System.out.println("Kehadiran : " + kt.getJumlahKehadiran() + " hari");
        System.out.println("-------------------------------------------------");
        System.out.printf("Total Gaji (dengan bonus kinerja): Rp%,.0f\n", kt.hitungGaji(bonus));
        System.out.println("-------------------------------------------------");
        System.out.println();

        // 2. Membuat objek KaryawanKontrak
        KaryawanKontrak kk = new KaryawanKontrak("Jamie", "KK-002", 150000);
        
        // Simulasi absen 21 kali agar dapat bonus validasi
        for (int i = 0; i < 22; i++) {
            kk.absen();
        }

        // Tampilkan hasil Karyawan Kontrak
        System.out.println("===== Data Karyawan Kontrak =====");
        System.out.println("ID        : " + kk.getIdKaryawan());
        System.out.println("Nama      : " + kk.getNama());
        System.out.println("Kehadiran : " + kk.getJumlahKehadiran() + " hari");
        System.out.println("-------------------------------------------------");
        System.out.printf("Total Gaji (termasuk bonus lembur): Rp%,.0f\n", kk.hitungGaji());
        System.out.println("-------------------------------------------------");
        
        System.out.println("\n----------------------------------");
    }
}