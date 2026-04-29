import java.util.Scanner;

public class Praktikum1no5 {
    public static void main (String[] args){
        Scanner input = new Scanner(System.in);

        // Membuat array 2D sesuai contoh di soal
        int[][] tabelAngka = {
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}  
        };

        try {
            System.out.print("Input : ");
            // Mengambil input dari angka yang dicari
            int cari = input.nextInt();
            
            boolean ditemukan = false;
            // Perulangan untuk baris (i)
            for (int i = 0; i < tabelAngka.length; i+=1) {
                // Perulangan untuk kolom (j) di dalam baris tersebut
                for (int j = 0; j < tabelAngka[i].length; j+=1) {
                    // Cek apakah angka di posisi [i][j] telah sama dengan angka yang dicari
                    if (tabelAngka[i][j] == cari) {
                        System.out.println("Found " + cari + " at [" + i + "][" + j + "]");
                        ditemukan = true;
                        break; // Berhenti dari perulangan kolom
                    }
                }
                // Jika sudah ketemu, kita harus hentikan perulangan baris juga
                if (ditemukan) {
                    break; 
                }
            }
            if (!ditemukan) {
                System.out.println("Angka " + cari + " tidak ditemukan dalam array.");
            }
        } catch (Exception e) {
            // Menangkap error jika user inputnya bukan angka (misal huruf)
            System.out.println("Terjadi kesalahan: Mohon masukkan angka bulat saja!");
        } finally {
            input.close();
        }

    }
}