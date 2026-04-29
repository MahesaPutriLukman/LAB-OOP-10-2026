package Soal1;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== BANGUN RUANG =====");
        System.out.println("1. KUBUS");
        System.out.println("2. BALOK");
        System.out.println("3. BOLA");
        System.out.println("4. TABUNG");

        System.out.println("\n===== BANGUN DATAR =====");
        System.out.println("5. PERSEGI");
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN");
        System.out.println("8. TRAPESIUM");

        int pilih;
        
        try {
                System.out.print("\nPilihan: ");
                pilih = input.nextInt();
                
                
            } catch (InputMismatchException e) {
                System.out.println("Error: Masukkan angka, bukan huruf!");
                input.nextLine(); 
                pilih = 0;
            }
        switch (pilih) {

            case 1:
                System.out.print("Masukkan sisi kubus: ");
                double s = input.nextDouble();
                Kubus k = new Kubus(s);

                System.out.println("Luas kubus: " + k.luas());
                System.out.println("Volume kubus: " + k.volume());
                break;

            case 2:
                System.out.print("Masukkan panjang: ");
                double p = input.nextDouble();

                System.out.print("Masukkan lebar: ");
                double l = input.nextDouble();

                System.out.print("Masukkan tinggi: ");
                double t = input.nextDouble();

                Balok b = new Balok(p, l, t);

                System.out.println("Luas balok: " + b.luas());
                System.out.println("Volume balok: " + b.volume());
                break;

            case 3:
                System.out.print("Masukkan jari-jari bola: ");
                double rB = input.nextDouble();

                Bola bola = new Bola(rB);

                System.out.println("Luas bola: " + bola.luas());
                System.out.println("Volume bola: " + bola.volume());
                break;

            case 4:
                System.out.print("Masukkan jari-jari tabung: ");
                double rT = input.nextDouble();

                System.out.print("Masukkan tinggi tabung: ");
                double tT = input.nextDouble();

                Tabung tabung = new Tabung(rT, tT);

                System.out.println("Luas tabung: " + tabung.luas());
                System.out.println("Volume tabung: " + tabung.volume());
                break;

            case 5:
                System.out.print("Masukkan sisi persegi: ");
                double sP = input.nextDouble();

                Persegi persegi = new Persegi(sP);

                System.out.println("Luas persegi: " + persegi.luas());
                System.out.println("Keliling persegi: " + persegi.keliling());
                break;

            case 6:
                System.out.print("Masukkan panjang: ");
                double pp = input.nextDouble();

                System.out.print("Masukkan lebar: ");
                double lp = input.nextDouble();

                PersegiPanjang pj = new PersegiPanjang(pp, lp);

                System.out.println("Luas persegi panjang: " + pj.luas());
                System.out.println("Keliling persegi panjang: " + pj.keliling());
                break;

            case 7:
                System.out.print("Masukkan jari-jari lingkaran: ");
                double rL = input.nextDouble();

                Lingkaran ling = new Lingkaran(rL);

                System.out.println("Luas lingkaran: " + ling.luas());
                System.out.println("Keliling lingkaran: " + ling.keliling());
                break;

            case 8:
                System.out.print("Masukkan sisi 1 trapesium: ");
                double s1 = input.nextDouble();

                System.out.print("Masukkan sisi 2 trapesium: ");
                double s2 = input.nextDouble();

                System.out.print("Masukkan sisi 3 trapesium: ");
                double s3 = input.nextDouble();

                System.out.print("Masukkan sisi 4 trapesium: ");
                double s4 = input.nextDouble();

                System.out.print("Masukkan tinggi trapesium: ");
                double tt = input.nextDouble();

                Trapesium tr = new Trapesium(s1, s2, s3, s4, tt);

                System.out.println("Luas trapesium: " + tr.luas());
                System.out.println("Keliling trapesium: " + tr.keliling());
                break;

            default:
                System.out.println("Pilihan tidak tersedia.");
        }

        input.close();
    }
}