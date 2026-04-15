package Tuprak3;

public class Main {
    public static void main(String[] args) {
        // Instansiasi objek baru
        DompetDigital dompetku = new DompetDigital ("123456", "Chao Yufan [CORTIS]");

        // Tampilkan informasi identitas akun menggunakan Getter. 
        System.out.println("\n===================================");
        System.out.println("Pemilik Akun: " + dompetku.getNamaPemilik());
        System.out.println("===================================\n");


        // Lakukan uji coba metode Setter (Ubah PIN) dengan memasukkan PIN lama yang salah (Pastikan sistem menolak). 
        System.out.println("-------------------------------------------------------------------------------------");
        dompetku.perbaruiPin("000000", "654321");

        // Lakukan uji coba metode Setter (Ubah PIN) dengan memenuhi syarat yang benar (Pastikan PIN berhasil diubah). 
        dompetku.perbaruiPin("123456", "654321");

        // Lakukan setor tunai dengan nominal yang valid. 
        dompetku.setorTunai(500000);

        // Lakukan setor tunai dengan nominal ilegal/negatif (Pastikan ditolak). 
        dompetku.setorTunai(-10000);

        // Lakukan tarik tunai menggunakan PIN yang lama/salah (Pastikan ditolak). 
        dompetku.tarikTunai(100000, "123456");

        // Lakukan tarik tunai menggunakan PIN yang baru/benar (Pastikan berhasil). 
        dompetku.tarikTunai(200000, "654321");
        System.out.println("-------------------------------------------------------------------------------------");


        // Tampilkan sisa saldo akhir menggunakan Getter.
        System.out.println("Sisa Saldo Akhir: Rp" + dompetku.getSaldo() + "\n");
        
    }
    
}
