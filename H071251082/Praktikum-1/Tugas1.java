import java.util.Scanner;

public class Tugas1 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Masukkan Judul Film :");
        String judul = x.nextLine();
        String judulKapital = "" ;

        String[] perKata = judul.split(" ");

        for (int i = 0; i < perKata.length; i++ ){
            String kata = perKata[i];

            if (kata.length() > 0) {
                String hurufPertama = kata.substring(0,1).toUpperCase();
                String sisaHuruf = kata.substring(1).toLowerCase();
                judulKapital += hurufPertama + sisaHuruf + " ";
            }
        }
        System.out.println(judulKapital);

    }
}