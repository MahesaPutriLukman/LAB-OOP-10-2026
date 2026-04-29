import java.util.Scanner;

public class Soal1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan Judul Film: ");
        String teks = input.nextLine();

        String[] kata = teks.split(" ");
        String hasil = "";

        for (int i = 0; i < kata.length; i++) { 
            if (kata[i].length() > 0) { 
                String hurufAwal = kata[i].substring(0, 1).toUpperCase();
                String sisa = kata[i].substring(1).toLowerCase();
                hasil = hasil + hurufAwal + sisa + " ";
            }
        }

        System.out.println(hasil.trim());

        input.close();
    }
}
