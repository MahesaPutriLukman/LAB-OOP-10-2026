import java.util.Scanner;
public class Tugas4 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int n = x.nextInt();
        int hasil = faktorial(n);

        System.out.println(hasil);
    }
    public static int faktorial (int n){
        if(n == 0 || n == 1){
            return 1;
        }else{
            return n*faktorial(n-1);
        }
    }
}