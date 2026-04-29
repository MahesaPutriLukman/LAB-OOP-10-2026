import java.util.Scanner;

public class soal_1 {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Masukkan Judul Film :");
        System.out.print("> ");
        
        String kalimatInput = inputScanner.nextLine();
        String hasil = formatKapital(kalimatInput);
        System.out.println("\nOutput:");
        System.out.println(hasil);

        inputScanner.close();
    }

    public static String formatKapital(String teks) {
        String hasilAkhir = "";
        boolean isAwalKata = true;

        for (int i = 0; i < teks.length(); i++) {
            char karakter = teks.charAt(i);

            if (karakter == ' ') {
                hasilAkhir = hasilAkhir + karakter;
                isAwalKata = true;
            } else if (isAwalKata) {
                hasilAkhir = hasilAkhir + Character.toUpperCase(karakter);
                isAwalKata = false;
            } else {
                hasilAkhir = hasilAkhir + Character.toLowerCase(karakter);
            }
        }
        
        return hasilAkhir;
    }
}