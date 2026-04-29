import java.util.Scanner;
import java.util.InputMismatchException;
public class Task5 {
    public static void main(String[] args) {
        Scanner InputAngka = new Scanner(System.in);
        int[][] Nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        Boolean Status = false;
        int Baris = 0;
        int Kolom = 0;
        String Izin = "\nSystems Done";
        try {
            System.out.println("Masukkan Angka: ");
            int Angka = InputAngka.nextInt();
            for (int i = 0; i < Nums.length; i++){
                for (int j = 0; j < Nums[i].length; j++) {
                    if (Nums[i][j] == Angka) {
                        Baris += i;
                        Kolom += j;
                        Status = true;
                        break;
                    } 
                }
            }
            if (Status){
                System.out.println("Found " + Angka + " at " + "["+ Baris +"]" + "["+ Kolom +"]");
            }
            else if (!Status){
                System.out.println("Angka tidak ditemukan!");
            }          

        } 
        catch (Exception e) {
            System.out.println("Inputan harus berupa angka!");
        }
        finally {
            System.out.println(Izin);
        }
        InputAngka.close();
    }
}