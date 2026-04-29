import java.util.Scanner;

public class Soal4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan angka : ");
        int n = input.nextInt();

        long hasil = faktorial(n);
        System.out.println("Faktorial : " + hasil);
        
        input.close();
    }

    public static long faktorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * faktorial(n - 1);
        }
    }
}