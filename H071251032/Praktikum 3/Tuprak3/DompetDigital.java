package Tuprak3;

public class DompetDigital {
    //1. Persyaratan Atribut
    private double saldo;          // Private: Sangat rahasia!
    private String pin;            // Private: Sangat rahasia!
    protected String namaPemilik;  // Protected: Untuk identitas 
    String statusInternal;         // Default: Pengaturan internal

    //2. Constructor
    public DompetDigital(String pinAwal, String nama) { //Constructor (public): Untuk menginisialisasi pembuatan akun baru
        this.pin = pinAwal;
        this.namaPemilik = nama;
        this.saldo = 0;            
        this.statusInternal = "Aktif";
    }
    
    //3. Getter {Aman untuk ditampilkan}
    public String getNamaPemilik() { 
        return namaPemilik;
    }
    public double getSaldo() {   
        return saldo;
    }

    //4. Setter (Ubah PIN)
    public void perbaruiPin(String pinLama, String pinBaru) {
        // Logika validasi: Cek PIN lama dan panjang PIN baru
        if (this.pin.equals(pinLama) && pinBaru.length() == 6) {
            this.pin = pinBaru;
            catatTransaksi("PIN Berhasil diubah!"); // Panggil method internal
        } else {
            catatTransaksi("Gagal Ubah PIN! PIN lama salah atau PIN baru anda bukan 6 digit!");
        }
    }

    //5. Metode Transaksi
    public void setorTunai(double jumlah) {
        if (jumlah > 0) { // Tidak boleh angka minus
            this.saldo += jumlah;
            catatTransaksi("Setor tunai berhasil: Rp." + jumlah);
        } else {
            catatTransaksi("TIDAK MENERIMA ANGKA NEGATIF!");
        }
    }

    public void tarikTunai(double jumlah, String inputPin) {
        // Verifikasi PIN dan saldo mencukupi
        if (this.pin.equals(inputPin) && this.saldo >= jumlah) {
            this.saldo -= jumlah;
            catatTransaksi("Tarik tunai berhasil: Rp." + jumlah);
        } else {
            catatTransaksi("Tarik tunai GAGAL! PIN salah atau saldo tidak cukup");
        }
    }

    //6. Method Internal
    private void catatTransaksi(String pesan) { // Hanya dipanggil dari dalam kelas
        System.out.println("[LOG SISTEM]: " + pesan);
    }
  
}
