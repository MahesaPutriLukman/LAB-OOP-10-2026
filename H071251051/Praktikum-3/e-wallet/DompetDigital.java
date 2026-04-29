class DompetDigital {

    // ATRIBUT PRIVATE (data paling rahasia) 
    private double saldo;       
    private String pin;         

    // ATRIBUT PROTECTED (bisa diakses subclass) 
    protected String idAkun;
    protected String namaNasabah;

    // ATRIBUT DEFAULT 
    String tipAkun;   

    // CONSTRUCTOR (public) 
    public DompetDigital(String idAkun, String namaNasabah, String pinAwal) {
        this.idAkun      = idAkun;
        this.namaNasabah = namaNasabah;
        this.pin         = pinAwal;
        this.saldo       = 0;        
        this.tipAkun     = "REGULER";  
        catatLog("Akun baru dibuat untuk " + namaNasabah);
        System.out.println("Akun E-Wallet berhasil dibuat untuk " + namaNasabah + "\n");
    }

    // METHOD INTERNAL (private) 
    private void catatLog(String pesan) {
        System.out.println("[LOG] " + pesan);
    }

    public double getSaldo() {
        return saldo;
    }

    public String getIdAkun() {    
        return idAkun;
    }

    public String getNamaNasabah() {  
        return namaNasabah;
    }

    public void tampilkanInfo() {
        System.out.println("\n=== INFORMASI AKUN ===");
        System.out.println("ID Akun      : " + idAkun);
        System.out.println("Nama         : " + namaNasabah);
        System.out.println("Tipe Akun    : " + tipAkun);
        System.out.println("Saldo        : Rp " + String.format("%,.0f", saldo));
        System.out.println("PIN          : ******** (rahasia)");
    }

    // Validasi ubah pin
    public void ubahPin(String pinLama, String pinBaru) {
        if (!pinLama.equals(this.pin)) {
            catatLog("Gagal ubah PIN: PIN lama salah");
            System.out.println("[GAGAL] PIN lama salah!");
            return;
        }
        if (pinBaru.length() != 6) {
            catatLog("Gagal ubah PIN: PIN baru tidak 6 digit");
            System.out.println("[GAGAL] PIN baru harus tepat 6 digit!");
            return;
        }
        this.pin = pinBaru;
        catatLog("PIN berhasil diubah");
        System.out.println("[BERHASIL] PIN berhasil diubah.");
    }

    public void setorTunai(double jumlah) {
        if (jumlah <= 0) {
            catatLog("Gagal setor: jumlah tidak valid (" + jumlah + ")");
            System.out.println("[GAGAL] Jumlah setor harus lebih besar dari 0!");
            return;
        }
        saldo += jumlah;
        catatLog("Setor tunai berhasil: Rp " + String.format("%,.0f", jumlah));
        System.out.println("[BERHASIL] Setor tunai Rp " + String.format("%,.0f", jumlah) + " berhasil.");
        System.out.println("Saldo sekarang : Rp " + String.format("%,.0f", saldo));
    }

    public void tarikTunai(double jumlah, String pinMasuk) {
        if (!pinMasuk.equals(this.pin)) {
            catatLog("Gagal tarik: PIN salah");
            System.out.println("[GAGAL] PIN yang Anda masukkan salah!");
            return;
        }
        if (jumlah <= 0) {
            catatLog("Gagal tarik: jumlah tidak valid (" + jumlah + ")");
            System.out.println("[GAGAL] Jumlah tarik harus lebih besar dari 0!");
            return;
        }
        if (jumlah > saldo) {
            catatLog("Gagal tarik: saldo tidak cukup");
            System.out.println("[GAGAL] Saldo tidak cukup!");
            System.out.println("Saldo Anda saat ini: Rp " + String.format("%,.0f", saldo));
            return;
        }
        saldo -= jumlah;
        catatLog("Tarik tunai berhasil: Rp " + String.format("%,.0f", jumlah));
        System.out.println("[BERHASIL] Tarik tunai Rp " + String.format("%,.0f", jumlah) + " berhasil.");
        System.out.println("Saldo sekarang : Rp " + String.format("%,.0f", saldo));
    }
}