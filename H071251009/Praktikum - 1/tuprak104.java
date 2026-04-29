import java.util.Scanner;
public class tuprak104 {
    public static void main(String[] args) {
    Scanner a = new Scanner(System.in);
    System.out.println("Masukkan angka");
    int bilangan = a.nextInt();
    int faktorial = 1;
    for (int i= 1; i <= bilangan; i++){
        faktorial *=i;
    }
    System.out.println(faktorial);
  }
}
