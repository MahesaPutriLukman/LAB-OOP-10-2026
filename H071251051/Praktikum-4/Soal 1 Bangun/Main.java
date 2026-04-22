import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan = 0;

        System.out.println("------------------------------------------");
        System.out.println("  ===== BANGUN RUANG =====");
        System.out.println("  1. KUBUS");
        System.out.println("  2. BALOK");
        System.out.println("  3. BOLA");
        System.out.println("  4. TABUNG");
        System.out.println();
        System.out.println("  ===== BANGUN DATAR =====");
        System.out.println("  5. PERSEGI");
        System.out.println("  6. PERSEGI PANJANG");
        System.out.println("  7. LINGKARAN");
        System.out.println("  8. TRAPESIUM");
        System.out.println("------------------------------------------");

        boolean inputValid = false;
        while (!inputValid) {
            System.out.print("Pilihan: ");
            try {
                pilihan = sc.nextInt();
                if (pilihan < 1 || pilihan > 8) {
                    System.out.println("[ERROR] Pilihan harus antara 1-8. Coba lagi!");
                } else {
                    inputValid = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Input tidak valid! Masukkan angka 1-8.");
                sc.nextLine();
            }
        }

        System.out.println("------------------------------------------");

        switch (pilihan) {
            case 1: {
                System.out.print("Masukkan sisi kubus: ");
                double sisi = bacaDouble(sc);
                Kubus kubus = new Kubus(sisi);
                kubus.tampilkanHasil();
                break;
            }
            case 2: {
                System.out.print("Masukkan panjang balok: ");
                double p = bacaDouble(sc);
                System.out.print("Masukkan lebar balok  : ");
                double l = bacaDouble(sc);
                System.out.print("Masukkan tinggi balok : ");
                double t = bacaDouble(sc);
                Balok balok = new Balok(p, l, t);
                balok.tampilkanHasil();
                break;
            }
            case 3: {
                System.out.print("Masukkan jari-jari bola: ");
                double r = bacaDouble(sc);
                Bola bola = new Bola(r);
                bola.tampilkanHasil();
                break;
            }
            case 4: {
                System.out.print("Masukkan jari-jari tabung: ");
                double r = bacaDouble(sc);
                System.out.print("Masukkan tinggi tabung   : ");
                double t = bacaDouble(sc);
                Tabung tabung = new Tabung(r, t);
                tabung.tampilkanHasil();
                break;
            }
            case 5: {
                System.out.print("Masukkan sisi persegi: ");
                double sisi = bacaDouble(sc);
                Persegi persegi = new Persegi(sisi);
                persegi.tampilkanHasil();
                break;
            }
            case 6: {
                System.out.print("Masukkan panjang: ");
                double p = bacaDouble(sc);
                System.out.print("Masukkan lebar  : ");
                double l = bacaDouble(sc);
                PersegiPanjang pp = new PersegiPanjang(p, l);
                pp.tampilkanHasil();
                break;
            }
            case 7: {
                System.out.print("Masukkan jari-jari lingkaran: ");
                double r = bacaDouble(sc);
                Lingkaran lingkaran = new Lingkaran(r);
                lingkaran.tampilkanHasil();
                break;
            }
            case 8: {
                System.out.print("Masukkan sisi 1 trapesium: ");
                double s1 = bacaDouble(sc);
                System.out.print("Masukkan sisi 2 trapesium: ");
                double s2 = bacaDouble(sc);
                System.out.print("Masukkan sisi 3 trapesium: ");
                double s3 = bacaDouble(sc);
                System.out.print("Masukkan sisi 4 trapesium: ");
                double s4 = bacaDouble(sc);
                System.out.print("Masukkan tinggi trapesium: ");
                double t = bacaDouble(sc);
                Trapesium trapesium = new Trapesium(s1, s2, s3, s4, t);
                trapesium.tampilkanHasil();
                break;
            }
        }

        System.out.println("------------------------------------------");
        sc.close();
    }

    private static double bacaDouble(Scanner sc) {
        while (true) {
            try {
                double nilai = sc.nextDouble();
                if (nilai <= 0) {
                    System.out.print("[ERROR] Nilai harus lebih dari 0. Coba lagi: ");
                } else {
                    return nilai;
                }
            } catch (InputMismatchException e) {
                System.out.print("[ERROR] Input tidak valid! Masukkan angka. Coba lagi: ");
                sc.nextLine();
            }
        }
    }
}