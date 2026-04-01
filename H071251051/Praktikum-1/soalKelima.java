import java.util.Scanner;

public class soalKelima {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] data = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.print("Masukkan angka yang ingin dicari: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Input harus angka!!");
            scanner.close(); 
            return;
        }

        int cari = scanner.nextInt();
        boolean ditemukan = false;

        try { 
            for (int i = 0; i < data.length; i++) { 
                try {
                    for (int j = 0; j < data[i].length; j++) {
                        try {
                            if (data[i][j] == cari) {
                                System.out.println("Found " + cari + " at [" + i + "][" + j + "]");
                                ditemukan = true;
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Error mengakses elemen [" + i + "][" + j + "]: " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("Error tidak terduga pada elemen [" + i + "][" + j + "]: " + e.getMessage());
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error pada baris ke-" + i + ": " + e.getMessage()); 
                }
            } 
        } catch (Exception e) {
            System.out.println("Error umum: " + e.getMessage()); 
        }

        
        if (!ditemukan) {
            System.out.println("Angka tidak ditemukan");
        }

        scanner.close(); 
    }
}