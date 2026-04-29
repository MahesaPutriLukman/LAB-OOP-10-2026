import java.util.Scanner;

public class Soal2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input (dd-mm-yy): ");
        String tgl = input.nextLine();

        String[] bagian = tgl.split("-");

        if (bagian.length == 3) {
            String hari = bagian[0];
            String bulanAngka = bagian[1];
            String tahunDuaDigit = bagian[2];

            int hariInt = Integer.parseInt(hari);

            String namaBulan = "";
            switch (bulanAngka) {
                case "01": namaBulan = "Januari"; break;
                case "02": namaBulan = "Februari"; break;
                case "03": namaBulan = "Maret"; break;
                case "04": namaBulan = "April"; break;
                case "05": namaBulan = "Mei"; break;
                case "06": namaBulan = "Juni"; break;
                case "07": namaBulan = "Juli"; break;
                case "08": namaBulan = "Agustus"; break;
                case "09": namaBulan = "September"; break;
                case "10": namaBulan = "Oktober"; break;
                case "11": namaBulan = "November"; break;
                case "12": namaBulan = "Desember"; break;
                default: namaBulan = "[Bulan Tidak Valid]";
            }

            int tahunInt = Integer.parseInt(tahunDuaDigit);
            String tahunFull;
            if (tahunInt <= 25) {
                tahunFull = "20" + tahunDuaDigit;
            } else {
                tahunFull = "19" + tahunDuaDigit;
            }

            System.out.println(hariInt + " " + namaBulan + " " + tahunFull);
        } else {
            System.out.println("Format input salah. Gunakan dd-mm-yy.");
        }

        input.close();
    }
}