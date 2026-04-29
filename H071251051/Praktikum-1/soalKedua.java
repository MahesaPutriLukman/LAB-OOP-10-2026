import java.util.Scanner;

public class soalKedua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan tanggal (format dd-mm-yy): ");
        String inputTanggal = scanner.nextLine();

        String hasil = konversiTanggal(inputTanggal);
        System.out.println("Tanggal: " + hasil);

        scanner.close();
    }

    public static String konversiTanggal(String tanggal) {
        String[] bagian = tanggal.split("-");

        int hari  = Integer.parseInt(bagian[0]);  
        int bulan = Integer.parseInt(bagian[1]);  
        int tahun = Integer.parseInt(bagian[2]);  

        String namaBulan = getNamaBulan(bulan);

        int tahunLengkap;
        if (tahun <= 29) {
            tahunLengkap = 2000 + tahun; 
        } else {
            tahunLengkap = 1900 + tahun;  
        }

        return hari + " " + namaBulan + " " + tahunLengkap;
    }

    public static String getNamaBulan(int nomorBulan) {

        switch (nomorBulan) {
            case 1:  return "Januari";
            case 2:  return "Februari";
            case 3:  return "Maret";
            case 4:  return "April";
            case 5:  return "Mei";
            case 6:  return "Juni";
            case 7:  return "Juli";
            case 8:  return "Agustus";
            case 9:  return "September";
            case 10: return "Oktober";
            case 11: return "November";
            case 12: return "Desember";
            default: return "Bulan Tidak Valid";
        }
    }
}