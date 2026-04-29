    import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ===== KARYAWAN TETAP =====
        System.out.println("========================================");
        System.out.println("       INPUT DATA KARYAWAN TETAP        ");
        System.out.println("========================================");

        // Input nama
        String namaTetap = "";
        while (namaTetap.isEmpty()) {
            System.out.print("Masukkan nama karyawan tetap : ");
            namaTetap = scanner.nextLine().trim();
            if (namaTetap.isEmpty()) {
                System.out.println("[ERROR] Nama tidak boleh kosong. Silakan coba lagi.");
            }
        }

        // Input ID
        String idTetap = "";
        while (idTetap.isEmpty()) {
            System.out.print("Masukkan ID karyawan tetap   : ");
            idTetap = scanner.nextLine().trim();
            if (idTetap.isEmpty()) {
                System.out.println("[ERROR] ID tidak boleh kosong. Silakan coba lagi.");
            }
        }

        // Input gaji pokok
        double gajiPokok = 0;
        while (gajiPokok <= 0) {
            System.out.print("Masukkan gaji pokok (Rp)     : ");
            try {
                gajiPokok = Double.parseDouble(scanner.nextLine().trim());
                if (gajiPokok <= 0) {
                    System.out.println("[ERROR] Gaji pokok harus lebih dari 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harus berupa angka.");
            }
        }

        // Input tunjangan makan
        double tunjanganMakan = -1;
        while (tunjanganMakan < 0) {
            System.out.print("Masukkan tunjangan makan/hari: ");
            try {
                tunjanganMakan = Double.parseDouble(scanner.nextLine().trim());
                if (tunjanganMakan < 0) {
                    System.out.println("[ERROR] Tunjangan makan tidak boleh negatif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harus berupa angka.");
                tunjanganMakan = -1;
            }
        }

        // Input jumlah kehadiran
        int kehadiranTetap = -1;
        while (kehadiranTetap < 0) {
            System.out.print("Masukkan jumlah kehadiran    : ");
            try {
                kehadiranTetap = Integer.parseInt(scanner.nextLine().trim());
                if (kehadiranTetap < 0) {
                    System.out.println("[ERROR] Jumlah kehadiran tidak boleh negatif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harus berupa angka bulat.");
            }
        }

        // Input bonus kinerja
        double bonusKinerja = -1;
        while (bonusKinerja < 0) {
            System.out.print("Masukkan bonus kinerja (Rp)  : ");
            try {
                bonusKinerja = Double.parseDouble(scanner.nextLine().trim());
                if (bonusKinerja < 0) {
                    System.out.println("[ERROR] Bonus kinerja tidak boleh negatif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harus berupa angka.");
                bonusKinerja = -1;
            }
        }

        // objek KaryawanTetap (validasi ada di dalam kelas)
        try {
            KaryawanTetap kt = new KaryawanTetap(namaTetap, idTetap, gajiPokok, tunjanganMakan);
            for (int i = 0; i < kehadiranTetap; i++) {
                kt.absen();
            }
            double totalGaji = kt.hitungGaji(bonusKinerja);

            System.out.println("\n========================================");
            System.out.println("       HASIL GAJI KARYAWAN TETAP        ");
            System.out.println("========================================");
            System.out.println("Nama          : " + kt.getNama());
            System.out.println("ID            : " + kt.getIdKaryawan());
            System.out.println("Kehadiran     : " + kt.getJumlahKehadiran() + " hari");
            System.out.printf ("Gaji Pokok    : Rp%.0f%n", gajiPokok);
            System.out.printf ("Tunjangan     : Rp%.0f x %d hari = Rp%.0f%n",
                    tunjanganMakan, kt.getJumlahKehadiran(), tunjanganMakan * kt.getJumlahKehadiran());
            System.out.printf ("Bonus Kinerja : Rp%.0f%n", bonusKinerja);
            System.out.printf ("Total Gaji    : Rp%.0f%n", totalGaji);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR dari Kelas] " + e.getMessage());
        }

        System.out.println();

        // ===== KARYAWAN KONTRAK =====
        System.out.println("========================================");
        System.out.println("      INPUT DATA KARYAWAN KONTRAK       ");
        System.out.println("========================================");

        // Input nama
        String namaKontrak = "";
        while (namaKontrak.isEmpty()) {
            System.out.print("Masukkan nama karyawan kontrak : ");
            namaKontrak = scanner.nextLine().trim();
            if (namaKontrak.isEmpty()) {
                System.out.println("[ERROR] Nama tidak boleh kosong. Silakan coba lagi.");
            }
        }

        // Input ID
        String idKontrak = "";
        while (idKontrak.isEmpty()) {
            System.out.print("Masukkan ID karyawan kontrak   : ");
            idKontrak = scanner.nextLine().trim();
            if (idKontrak.isEmpty()) {
                System.out.println("[ERROR] ID tidak boleh kosong. Silakan coba lagi.");
            }
        }

        // Input upah per hari
        double upahPerHari = 0;
        while (upahPerHari <= 0) {
            System.out.print("Masukkan upah per hari (Rp)    : ");
            try {
                upahPerHari = Double.parseDouble(scanner.nextLine().trim());
                if (upahPerHari <= 0) {
                    System.out.println("[ERROR] Upah per hari harus lebih dari 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harus berupa angka.");
            }
        }

        // Input jumlah kehadiran
        int kehadiranKontrak = -1;
        while (kehadiranKontrak < 0) {
            System.out.print("Masukkan jumlah kehadiran      : ");
            try {
                kehadiranKontrak = Integer.parseInt(scanner.nextLine().trim());
                if (kehadiranKontrak < 0) {
                    System.out.println("[ERROR] Jumlah kehadiran tidak boleh negatif.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harus berupa angka bulat.");
            }
        }

        // objek KaryawanKontrak (validasi ada di dalam kelas)
        try {
            KaryawanKontrak kk = new KaryawanKontrak(namaKontrak, idKontrak, upahPerHari);
            for (int i = 0; i < kehadiranKontrak; i++) {
                kk.absen();
            }
            double totalGajiKontrak = kk.hitungGaji();

            System.out.println("\n========================================");
            System.out.println("      HASIL GAJI KARYAWAN KONTRAK       ");
            System.out.println("========================================");
            System.out.println("Nama          : " + kk.getNama());
            System.out.println("ID            : " + kk.getIdKaryawan());
            System.out.println("Kehadiran     : " + kk.getJumlahKehadiran() + " hari");
            System.out.printf ("Upah/Hari     : Rp%.0f%n", upahPerHari);
            System.out.printf ("Upah Total    : Rp%.0f x %d = Rp%.0f%n",
                    upahPerHari, kk.getJumlahKehadiran(), upahPerHari * kk.getJumlahKehadiran());
            if (kk.getJumlahKehadiran() > 20) {
                System.out.println("Bonus Flat    : Rp500.000 (hadir lebih dari 20 hari)");
            }
            System.out.printf ("Total Gaji    : Rp%.0f%n", totalGajiKontrak);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR dari Kelas] " + e.getMessage());
        }

        scanner.close();
    }
}
