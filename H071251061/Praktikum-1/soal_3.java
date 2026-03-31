import java.util.Scanner;

public class soal_3{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (cekValiditas(password)) {
            System.out.println("Output : Password valid");
        } else {
            System.out.println("Output : Password tidak valid");
        }

        scanner.close();
    }

    public static boolean cekValiditas(String pass) {
        if (pass.length() < 8) return false;

        boolean adaBesar = false, adaKecil = false, adaAngka = false;

        for (char c : pass.toCharArray()) {
            if (Character.isUpperCase(c)) adaBesar = true;
            if (Character.isLowerCase(c)) adaKecil = true;
            if (Character.isDigit(c))     adaAngka = true;
            if (adaBesar && adaKecil && adaAngka) return true;
        }

        return false;
    }
}