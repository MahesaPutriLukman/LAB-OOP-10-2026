//Buat program yang mengkonversi tanggal dalam format "dd-mm-yy" menjadi format lebih jelas
import java.util.Scanner;

public class Praktikum1no2 {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan format dd-mm-yy: ");
        String tanggalInputan = input.nextLine();

        //memecah inputan
        String[] bagian = tanggalInputan.split("-");
        //mengambil hari
        int tanggal = Integer.parseInt(bagian[0]);

        //mengambil bulan menggunakan array
        // Kotak ke-0 sengaja dikosongkan agar Januari pas di kotak ke-1
        String[] daftarBulan = {
            "", "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };
        String namaBulan = daftarBulan[Integer.parseInt(bagian[1])];

        // Ambil Tahun (Logika 1900 atau 2000)
        int tahunDuaAngka = Integer.parseInt(bagian[2]);
        int tahunLengkap;
        
        if (tahunDuaAngka <= 26) {
            // Jika angkanya 0-26, kita anggap tahun 2000-an
            tahunLengkap = 2000 + tahunDuaAngka;
        } else {
            // Jika angkanya di atas 26, kita anggap tahun 1900-an
            tahunLengkap = 1900 + tahunDuaAngka;
        }

        System.out.println("perbaikan: " + tanggal + " " + namaBulan + " " + tahunLengkap);
        input.close();
    }
}
