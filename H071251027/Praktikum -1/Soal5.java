import java.util.Scanner;

public class Soal5 {
    public static void main(String[] args) {
        int[][] angka = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Scanner input = new Scanner(System.in);
        
        try {
            System.out.print("Masukkan angka : ");
            int cari = input.nextInt();
            
            
            boolean ditemukan = false;

            for (int b = 0; b < angka.length; b++) {
                for (int k = 0; k < angka[b].length; k++) {
                    if (angka[b][k] == cari) {
                        System.out.println("Found " + cari + " at [" + b + "][" + k + "]");
                        ditemukan = true;
                        break;
                    }
                }

                if (ditemukan) {
                    
                    break;
                }
            }

            if (!ditemukan) {
                System.out.println("Angka " + cari + " tidak ditemukan.");
            }

        } catch (Exception e) {
            System.out.println("Mohon masukkan angka bulat saja.");
        } finally {
            input.close();
        }
    }
}