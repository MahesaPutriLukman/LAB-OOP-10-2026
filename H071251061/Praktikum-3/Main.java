

public class Main{
    public static void main(String[] args) {
        CelenganDigital celengan1 = new CelenganDigital("Jack Owi", "112233", "celdig");

        System.out.println("\n=== Pengujian Dompet Digital ===");

        System.out.println("Pemilik Akun: " + celengan1.getNamaPemilik());

        System.out.println("\n--- Uji Ubah PIN (BERHASIL) --- ");
        celengan1.ubahPin("112233", "223311");

        System.out.println("\n--- Uji Ubah PIN (GAGAL) --- ");
        celengan1.ubahPin("000000", "221133");

        System.out.println("\n--- Uji Menabung Valid ---");
        celengan1.menabung(20);

        System.out.println("\n--- Uji Menabung Ilegal (-10000) ---");
        celengan1.menabung(-10);

        System.out.println("\n--- Uji Tarik Tunai (PIN Lama/Salah) ---");
        celengan1.bongkar(10, "110099");

        System.out.println("\n--- Uji Tarik Tunai (PIN Baru/Benar) ---");
        celengan1.bongkar(10, "223311");

        
    }
}