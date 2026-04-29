import java.util.Scanner;

public class soal_5 {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 11}};
        Scanner sc = new Scanner(System.in);

        System.out.print("Input : ");
        try {
            int target = sc.nextInt();

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == target) {
                        System.out.println("Found " + target + " at [" + i + "][" + j + "]");
                        return;
                    }
                }
            }
            System.out.println("Angka " + target + " tidak ditemukan.");

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: Masukkan angka bulat.");
        } finally {
            sc.close();
        }
    }
}