import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner InputTanggal = new Scanner(System.in);
        System.out.println("Masukkan Tanggal (dd-mm-yy): ");
        String Tanggal = InputTanggal.nextLine();
        
        String[] Ubah = Tanggal.split ("-");
        int Hari = Integer.parseInt(Ubah [0]);
        int Bulan = Integer.parseInt(Ubah [1]);
        int Tahun = Integer.parseInt(Ubah [2]);
        
        String[] NamaBulan = {
            "Januari","Februari","Maret","April","Mei","Juni",
            "Juli","Agustus","September","Oktober","November","Desember"
        };

        if (Tahun > 45 && Tahun < 100) {
            Tahun += 1900;
        }
        else {
            Tahun += 2000;
        }
        System.out.println(Hari + " " + NamaBulan [Bulan-1] + " " + Tahun);
        InputTanggal.close();
    }
}