// Mengubah semua huruf pertama menjadi kapital dan sisanya kapitil
import java.util.Scanner;

public class Praktikum1no1{
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan sebuah judul: ");
        String judulAwal = input.nextLine();

        //Membuat variabel untuk menampung pecahan kalimat yang dipecah berdasarkan spasinya
        String[] kumpulanKata = judulAwal.split(" ");
        String hasilAkhir = "";

        for (String kata : kumpulanKata){
            if (kata.length() > 0) {
                
                hasilAkhir += kata.substring(0, 1).toUpperCase() //mengambil huruf pertama dan mengubahnya menjadi kapital
                + kata.substring(1).toLowerCase() + " "; //mengubah sisa huruf yang ada menjadi kecil
            }
        }

        System.out.println("Perbaikan Judul: " + hasilAkhir);
        input.close();

    }
}