package cobasaja;

public class Celengan {
    // 1. Atribut Private 
    private int koin;
    private String pin;

    // 2. Atribut Protected 
    protected String namaPemilik;

    // 3. Atribut Default 
    String tipeCelengan;

    // 4. Constructor 
    public Celengan(String namaPemilik, String pin) {
        this.namaPemilik = namaPemilik;
        this.pin = pin;
        this.koin = 0; 
        this.tipeCelengan = "Babi Ngepet"; 
    }

    // 5. Getter 
    public String getNamaPemilik() {
        return namaPemilik;
    }

    // 6. Setter dengan Validasi 
    public void ubahPin(String pinLama, String pinBaru) {
        if (this.pin.equals(pinLama)) {
            this.pin = pinBaru;
            log("PIN berhasil diubah.");
        } else {
            log("Gagal! PIN lama salah.");
        }
    }

    // 7. Transaksi 1: Setor (Tidak boleh negatif) 
    public void nabung(int jumlah) {
        if (jumlah > 0) {
            this.koin += jumlah;
            log("Nabung sukses: +" + jumlah);
        }
    }

    // 8. Transaksi 2: Tarik (Cek PIN & Saldo) 
    public void bongkar(int jumlah, String inputPin) {
        if (this.pin.equals(inputPin) && this.koin >= jumlah) {
            this.koin -= jumlah;
            log("Bongkar sukses: -" + jumlah);
        } else {
            log("Gagal! PIN salah atau koin kurang.");
        }
    }

    // 9. Method Internal (Private) 
    private void log(String pesan) {
        System.out.println(">> Info: " + pesan);
    }
}




    








