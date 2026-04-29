import java.util.Scanner;
public class Tugas2 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.println("Masukkan tanggal dalam format dd-mm-yy");
        String tanggal = x.nextLine();

        String[] perBagian = tanggal.split("-");
        String hari = perBagian[0];
        String bulan = perBagian[1];
        String tahun = perBagian[2];

        if (hari.charAt(0) == '0'){
            hari = hari.substring(1);
        }
        switch (bulan) {
            case "01": bulan = "Januari"; break;
            case "02": bulan = "Februari"; break;
            case "03": bulan = "Maret"; break;
            case "04": bulan = "April"; break;
            case "05": bulan = "Mei"; break;
            case "06": bulan = "Juni"; break;
            case "07": bulan = "Juli"; break;
            case "08": bulan = "Agustus"; break;
            case "09": bulan = "September"; break;
            case "10": bulan = "Oktober"; break;
            case "11": bulan = "November"; break;
            case "12": bulan = "Desember"; break;
        }
        if (tahun.charAt(0) == '0' || tahun.charAt(0) == '1' || tahun.charAt(0) == '2'){
                tahun = "20" + tahun;
        }else{
            tahun = "19" + tahun;
        }
        System.out.println(hari + " " + bulan + " " + tahun);
    }
}