import java.util.Scanner;

public class soal_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input : ");

        if (!sc.hasNextInt()) {
            System.out.println("Output : Masukkan angka yang valid!");
            return;
        }

        int n = sc.nextInt();
        System.out.println(n < 0 ? "Output : Angka harus non-negatif!" : "Output : " + hitungFaktorial(n));
        sc.close();
    }

    public static long hitungFaktorial(int n) {
        return (n <= 1) ? 1 : n * hitungFaktorial(n - 1);
    }
}