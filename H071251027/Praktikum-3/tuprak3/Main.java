package tuprak3;

public class Main {
    public static void main(String[] args) {
        DompetDigital dompet = new DompetDigital("Almendo07", "123456");

        // 1. Tampilkan identitas menggunakan Getter
        System.out.println("1. Identitas Akun:");
        System.out.println("   ID Nasabah : " + dompet.getIdNasabah());
        System.out.println("   Saldo Awal : Rp" + dompet.getSaldo());

        // 2. Coba Setter (Ubah PIN) dengan PIN lama SALAH
        System.out.println("2. Ubah PIN (PIN Lama Salah):");
        dompet.ubahPin("000000", "654321");

        // 3. Coba Setter (Ubah PIN) dengan syarat BENAR
        System.out.println("3. Ubah PIN (Syarat Benar):");
        dompet.ubahPin("123456", "654321");

        // 4. Setor tunai nominal VALID
        System.out.println("4. Setor Tunai Valid:");
        dompet.setorTunai(1000000);

        // 5. Setor tunai nominal ILEGAL/Negatif
        System.out.println("5. Setor Tunai Negatif:");
        dompet.setorTunai(-200000);

        // 6. Tarik tunai dengan PIN lama/SALAH (PIN sudah berubah di langkah 3)
        System.out.println("6. Tarik Tunai (PIN Lama):");
        dompet.tarikTunai(300000, "123456");

        // 7. Tarik tunai dengan PIN baru/BENAR
        System.out.println("7. Tarik Tunai (PIN Baru):");
        dompet.tarikTunai(300000, "654321");

        // 8. Tampilkan sisa saldo akhir menggunakan Getter
        System.out.println("8. Sisa Saldo Akhir:");
        System.out.println("   Saldo Sekarang: Rp" + dompet.getSaldo());

    }
}