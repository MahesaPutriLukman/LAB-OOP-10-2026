package live;

public class celengan {
    private int koin;
    private String pin;
    protected String namaPemilik;
      
    String tipeCelengan;
    
    public double getSaldo() {
        return koin;
    }
    public celengan(String namaPemilik, String pinAwal) {
        this.namaPemilik = namaPemilik;
        this.pin = pinAwal;
        this.tipeCelengan = "Sintara";
        this.koin= 0;
    }
    
    public String getNamaPemilik() {
         return namaPemilik;
    }

    public void ubahPin(String pinLama, String pinBaru) {
        if (!pinLama.equals(this.pin)) {
            System.out.println("   PIN lama salah!");
            log("Percobaan ubah PIN ditolak (PIN lama salah)");
            return;
        }
        this.pin = pinBaru;
        System.out.println("   Berhasil: PIN telah diubah.");
        log("PIN berhasil diubah menjadi baru.");}

    public void setorTunai(double jumlah) {
        if (jumlah <= 0) {
            System.out.println("   Gagal: Nominal setor harus positif!");
            log("Setor tunai ditolak: nominal <= 0");
            return;
        }
    }
    public void tarikTunai(double jumlah, String pinInput) {
        if (!pinInput.equals(this.pin)) {
            System.out.println("   Gagal: PIN salah!");
            log("Tarik tunai ditolak: PIN salah");
            return;
        }
        if (jumlah > this.koin) {
            System.out.println("   Gagal: Saldo tidak mencukupi!");
            log("Tarik tunai ditolak: saldo kurang");
            return;
        }
        if (jumlah <= 0) {
            System.out.println("Gagal: Nominal tarik harus positif!");
            return;
        }
        this.koin -= jumlah;
        System.out.println("   Berhasil tarik tunai: Rp" + jumlah);
        log("Tarik tunai berhasil: Rp" + jumlah);
    }
    private void log(String pesan) {
        System.out.println("   [SYSTEM LOG] " + pesan);
    }    
}
    