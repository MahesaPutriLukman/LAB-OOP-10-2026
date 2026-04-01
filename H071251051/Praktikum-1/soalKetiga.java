import java.util.Scanner;

public class soalKetiga {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Password: ");
        String password = scanner.nextLine();

        if (validasiPassword(password)) {
            System.out.println("Password valid!");
        } else {
            System.out.println("Password tidak valid.");
            System.out.println("Password harus minimal 8 karakter dan mengandung huruf besar, huruf kecil, dan angka.");
        }
    }

    public static boolean validasiPassword(String password) {
        if (password.length() < 8) return false;

        boolean adaHurufBesar = false;
        boolean adaHurufKecil = false;
        boolean adaAngka      = false;

        for (char c : password.toCharArray()) {
            if      (Character.isUpperCase(c)) adaHurufBesar = true;
            else if (Character.isLowerCase(c)) adaHurufKecil = true;
            else if (Character.isDigit(c))     adaAngka      = true;
        }

        return adaHurufBesar && adaHurufKecil && adaAngka;
    }
}