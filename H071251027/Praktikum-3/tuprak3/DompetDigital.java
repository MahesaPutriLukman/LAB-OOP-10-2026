package tuprak3;

public class DompetDigital {
    // 1. Atribut PRIVATE
    private String pin;
    private double saldo;

    // 2. Atribut PROTECTED 
    protected String idNasabah;

    // 3. Atribut DEFAULT / PACKAGE-PRIVATE (internal package)
    String statusSistem;

    // Constructor Public: Inisialisasi akun, saldo otomatis 0
    public DompetDigital(String idNasabah, String pinAwal) {
        this.idNasabah = idNasabah;
        this.pin = pinAwal;
        this.saldo = 0.0;
        this.statusSistem = "AKTIF";
        log("Akun berhasil dibuat. ID: " + idNasabah);
    }

    // Getter Public (Hanya untuk data yang AMAN ditampilkan)
    public String getIdNasabah() {
        return idNasabah;
    }

    public double getSaldo() {
        return saldo;
    }

    // Setter dengan validasi ketat
    public void ubahPin(String pinLama, String pinBaru) {
        if (!pinLama.equals(this.pin)) {
            System.out.println("   Gagal: PIN lama salah!");
            log("Percobaan ubah PIN ditolak (PIN lama salah)");
            return;
        }
        if (pinBaru == null || pinBaru.length() != 6) {
            System.out.println("Gagal: PIN baru harus tepat 6 karakter!");
            log("Percobaan ubah PIN ditolak (panjang PIN != 6)");
            return;
        }
        this.pin = pinBaru;
        System.out.println("   Berhasil: PIN telah diubah.");
        log("PIN berhasil diubah menjadi baru.");
    }

    // Metode Transaksi 1: Setor Tunai
    public void setorTunai(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("   Gagal: Nominal setor harus positif!");
            log("Setor tunai ditolak: nominal <= 0");
            return;
        }
        this.saldo += jumlah;
        System.out.println("   Berhasil setor tunai: Rp" + jumlah);
        log("Setor tunai berhasil: Rp" + jumlah);
    }

    // Metode Transaksi 2: Tarik Tunai
    public void tarikTunai(double jumlah, String pinInput) {
        if (!pinInput.equals(this.pin)) {
            System.out.println("   Gagal: PIN salah!");
            log("Tarik tunai ditolak: PIN salah");
            return;
        }
        if (jumlah > this.saldo) {
            System.out.println("Gagal: Saldo tidak mencukupi!");
            log("Tarik tunai ditolak: saldo kurang");
            return;
        }
        if (jumlah <= 0) {
            System.out.println("Gagal: Nominal tarik harus positif!");
            return;
        }
        this.saldo -= jumlah;
        System.out.println("   Berhasil tarik tunai: Rp" + jumlah);
        log("Tarik tunai berhasil: Rp" + jumlah);
    }

    // Metode Internal (Hanya dipanggil dari dalam kelas)
    private void log(String pesan) {
        System.out.println("   [SYSTEM LOG] " + pesan);
    }
}