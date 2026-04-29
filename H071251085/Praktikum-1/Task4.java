import java.util.Scanner;
public class Task4 {
    public static int faktorial(int n) {
        if (n == 0 || n == 1) { // base case
            return 1;
        } else {
            return n * faktorial(n - 1); // recursive case
        }
    }
    public static void main(String[] args) {
        Scanner InputAngka = new Scanner(System.in);
        System.out.print("Masukkan Angka: ");
        int Angka = InputAngka.nextInt();

        int Hasil = faktorial(Angka);

        System.out.println("Hasil Faktorial: " + Hasil);
        InputAngka.close();
    }
}