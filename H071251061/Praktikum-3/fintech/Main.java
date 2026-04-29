package fintech;

public class Main{
    public static void main(String[] args) {
        DompetDigital dompetKu = new DompetDigital ("BNI-221349", "Jack Owi", "112233" );

        System.out.println("\n=== Pengujian Dompet Digital ===");

        System.out.println("Pemilik Akun: " + dompetKu.getNamaNasabah());

        System.out.println("\n--- Uji Ubah PIN (BERHASIL) --- ");
        dompetKu.setPin("112233", "223311");

        System.out.println("\n--- Uji Ubah PIN (GAGAL) --- ");
        dompetKu.setPin("000000", "221133");

        System.out.println("\n--- Uji Setor Tunai Valid ---");
        dompetKu.setorTunai(500000);

        System.out.println("\n--- Uji Setor Tunai Ilegal (-10000) ---");
        dompetKu.setorTunai(-10000);

        System.out.println("\n--- Uji Tarik Tunai (PIN Lama/Salah) ---");
        dompetKu.tarikTunai(100000, "123456");

        System.out.println("\n--- Uji Tarik Tunai (PIN Baru/Benar) ---");
        dompetKu.tarikTunai(200000, "223311");

        System.out.println("\nSisa Saldo Akhir: Rp" + dompetKu.getSaldo());
    }
}