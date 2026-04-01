import java.util.Scanner;

public class soalPertama {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Masukkan Judul Film :");
        String judul = scanner.nextLine();
        
        String judulRapi = capitalize(judul); 
        System.out.println(judulRapi);
    }

    public static String capitalize(String judul) {
        String[] kata = judul.toLowerCase().split(" ");
        
        String hasil = "";

        for (String k : kata) {
            if (k.length() > 0) {
                hasil += Character.toUpperCase(k.charAt(0)) + k.substring(1) + " ";
            }
        }
        return hasil.trim();
    }
}