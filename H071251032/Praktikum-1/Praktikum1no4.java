//Rekursi adalah kondisi di mana sebuah fungsi memanggil dirinya sendiri
//Rumus faktorial n! = n x (n-1)!
import java.util.Scanner;
public class Praktikum1no4 {
    public static void main (String[] args) {
        Scanner input = new Scanner (System.in);

        System.out.print("Massukkan sebuah nilai faktorial(!): ");
        int n = input.nextInt();

        //perkondisian apabila user memasukkan nilai minus
       if (n < 0) {
            System.out.println("Faktorial tidak terdefinisi untuk bilangan negatif!");
        } else {
            // Memanggil fungsi rekursif hanya jika angkanya 0 atau positif
            int hasil = hitungFaktorial(n);
            System.out.println("Hasil faktorial: " + hasil);
        }
        input.close();
    }

    // Fungsi rekursi untuk menghitung faktorial
    public static int hitungFaktorial (int n) {
        // Base case: Kondisi berhenti agar tidak terjadi perulangan tanpa batas
        if (n == 0 || n == 1){
            return 1;
        }
        // Rekursi: Memanggil fungsi itu sendiri
        return n * hitungFaktorial (n - 1);
    }


}