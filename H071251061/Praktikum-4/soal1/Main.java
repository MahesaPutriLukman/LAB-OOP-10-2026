package soal1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean interaksi = true;

        while (interaksi) {
            try {
                System.out.println("\n======= MENU GEOMETRI =======");
                System.out.println("1. KUBUS          5. PERSEGI");
                System.out.println("2. BALOK          6. PERSEGI PANJANG");
                System.out.println("3. BOLA           7. LINGKARAN");
                System.out.println("4. TABUNG         8. TRAPESIUM");
                System.out.println("0. KELUAR");
                
                System.out.print("\nPilihan Anda: ");
                int pilihan = input.nextInt();
                System.out.println("-------------------------------------------");

                if (pilihan == 0) {
                    System.out.println("Terima kasih! Program selesai.");
                    interaksi = false;
                    break;
                }

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan sisi kubus: ");
                        new Kubus().hitung(input.nextDouble());
                        break;
                    case 2:
                        System.out.print("Masukkan panjang: "); double p = input.nextDouble();
                        System.out.print("Masukkan lebar: "); double l = input.nextDouble();
                        System.out.print("Masukkan tinggi: "); double t = input.nextDouble();
                        new Balok().hitung(p, l, t);
                        break;
                    case 3:
                        System.out.print("Masukkan jari-jari bola: ");
                        new Bola().hitung(input.nextDouble());
                        break;
                    case 4:
                        System.out.print("Masukkan jari-jari tabung: "); double rT = input.nextDouble();
                        System.out.print("Masukkan tinggi tabung: "); double tT = input.nextDouble();
                        new Tabung().hitung(rT, tT);
                        break;
                    case 5:
                        System.out.print("Masukkan sisi persegi: ");
                        new Persegi().hitung(input.nextDouble());
                        break;
                    case 6:
                        System.out.print("Masukkan panjang: "); double pP = input.nextDouble();
                        System.out.print("Masukkan lebar: "); double lP = input.nextDouble();
                        new PersegiPanjang().hitung(pP, lP);
                        break;
                    case 7:
                        System.out.print("Masukkan jari-jari: ");
                        new Lingkaran().hitung(input.nextDouble());
                        break;
                    case 8:
                        System.out.print("Sisi 1: "); double s1 = input.nextDouble();
                        System.out.print("Sisi 2: "); double s2 = input.nextDouble();
                        System.out.print("Sisi 3: "); double s3 = input.nextDouble();
                        System.out.print("Sisi 4: "); double s4 = input.nextDouble();
                        System.out.print("Tinggi: "); double tTr = input.nextDouble();
                        new Trapesium().hitung(s1, s2, s3, s4, tTr);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Gunakan angka 0-8.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Kesalahan: Harap masukkan angka (bukan huruf/simbol)!");
                input.nextLine();
            }
        }
        input.close();
    }
}