import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {
        Scanner InputPassword = new Scanner(System.in);
        System.out.println("Masukkan Password: ");
        String Password = InputPassword.nextLine();
        
        String [] Ubah = Password.split("");
        Boolean HurufKapital = false;
        Boolean HurufNonKapital = false;
        Boolean Angka = false;

        if (Ubah.length < 8){
            System.out.println("Password tidak valid!\nPassword minimal 8 karakter");
        }
        else {
            for (int i = 0; i < Ubah.length; i++){
                char Subject = Password.charAt(i);
                if (Character.isUpperCase(Subject)){
                    HurufKapital = true;
                }
                else if (Character.isLowerCase(Subject)){
                    HurufNonKapital = true;
                }
                else if (Character.isDigit(Subject)){
                    Angka = true;
                }
            }
            if (HurufKapital && HurufNonKapital && Angka) {
                System.out.println("Password valid");
            } else {
                System.out.println("Password tidak valid!\nPassword harus mengandung huruf kapital, huruf non kapital, dan angka");
            }
        }
        InputPassword.close();
    }
}