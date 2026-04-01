import java.util.Scanner;

public class soalKeempat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan angka: ");
        int bilangan = scanner.nextInt();

        System.out.println(faktorial(bilangan));
    }

    public static long faktorial(int n) {
        if (n <= 1) return 1;
        return n * faktorial(n - 1);
    }
}