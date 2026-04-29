//Buat program untuk meminta input password dari pengguna dan validasi 
import java.util.Scanner;

public class Praktikum1no3 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan password: ");
        String password = input.nextLine();

        boolean hufurKapital = false;
        boolean hurufKapitil = false;
        boolean adaAngka = false;

        //melakukan pengecekkan apakah pass berisi 8 karakter
        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i += 1) {
                char c = password.charAt(i);
                
                if (Character.isUpperCase(c)) {
                    hufurKapital = true;
                } else if (Character.isLowerCase(c)) {
                    hurufKapitil = true;
                } else if (Character.isDigit(c)) {
                    adaAngka = true;
                }
            }
        }

        // melakukan validasi password
        if (password.length() >= 8 && hufurKapital && hurufKapitil && adaAngka) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }

        input.close();

    }
}