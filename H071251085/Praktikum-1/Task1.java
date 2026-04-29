import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner InputKalimat = new Scanner(System.in);
        System.out.println("Masukkan Judul Film: ");
        String Kalimat = InputKalimat.nextLine();
        String KalimatBaru = ("");
        String[] Kata = Kalimat.split (" ");

        for (int i = 0; i < Kata.length; i++) {
            String HurufKapital = Kata[i].substring(0, 1).toUpperCase();
            String HurufNonKapital = Kata[i].substring(1).toLowerCase();
            KalimatBaru += (HurufKapital + HurufNonKapital + " ");
        }
        System.out.println(KalimatBaru);
        InputKalimat.close();
    }
}