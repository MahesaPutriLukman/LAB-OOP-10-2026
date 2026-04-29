import java.util.Scanner;

public class soal_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] namaBulan = {
            "", "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String input = sc.nextLine();

        if (input.matches("\\d{2}-\\d{2}-\\d{2}")) {
            String[] bagian = input.split("-");
            
            int tgl = Integer.parseInt(bagian[0]);
            int bln = Integer.parseInt(bagian[1]);
            int thn = Integer.parseInt(bagian[2]);

            String tahunLengkap = (thn <= 30) ? "20" + bagian[2] : "19" + bagian[2];

            if (bln >= 1 && bln <= 12) {
                System.out.println("\nOutput:");
                System.out.println(tgl + " " + namaBulan[bln] + " " + tahunLengkap);
            } else {
                System.out.println("Bulan tidak valid!");
            }
        } else {
            System.out.println("Format salah! Gunakan dd-mm-yy (contoh: 01-04-03)");
        }
        
        sc.close();
    }
}