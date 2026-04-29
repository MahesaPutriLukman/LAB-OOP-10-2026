import java.util.Scanner;
public class Tugas3 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Masukkan Password :");
        String pass = x.nextLine();

        boolean hurufBesar = false;
        boolean hurufKecil = false;
        boolean angka = false;

        if(pass.length() >= 8){
            for(int i = 0; i < pass.length(); i++){
                char huruf = pass.charAt(i);
                
                if(huruf >= 'A' && huruf <= 'Z'){
                    hurufBesar = true;
                }
                if(huruf >= 'a' && huruf <= 'z'){
                    hurufKecil = true;
                }
                if(huruf >= '0' && huruf <= '9'){
                    angka = true;
                }
            }
        }
        if(pass.length() >= 8 && hurufBesar == true && hurufKecil == true && angka == true){
            System.out.println("Password valid.");
        }else{
            System.out.println("Password tidak valid.");
        }
    }
}