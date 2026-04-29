import java.util.Scanner;

public class Soal3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = input.nextLine();

        boolean digit = password.length() >= 8;
        boolean hurufBesar = false;
        boolean hurufKecil = false;
        boolean angka = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i); 

            if (Character.isUpperCase(c)) {
                hurufBesar = true;
            } else if (Character.isLowerCase(c)) {
                hurufKecil = true;
            } else if (Character.isDigit(c)) {
                angka = true;
            } else {
                System.out.println("Karakter '" + c + "' adalah simbol/spasi.");
            }
        }

        if (digit && hurufBesar && hurufKecil && angka) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }

        input.close();
    }
}