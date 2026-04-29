package LiveCoding;

public class Celengan {
    private int koin;
    private String pin;
    protected String namaPemilik;
    String tipeCelengan;
    
    public Celengan(String pinAwal, String nama) { 
        this.pin = pinAwal;
        this.namaPemilik = nama;
        this.koin = 0;            
        this.tipeCelengan = "Remboo";
    }

    public String getNamaPemilik() { 
        return namaPemilik;
    }

    public void ubahPin (String pinLama, String pinBaru) {
        if (this.pin.equals(pinLama)) {
            this.pin = pinBaru;
            catatKegiatan("PIN anda berhasil diubah!"); // Panggil method internal
        } else {
            catatKegiatan("GAGAL! PIN anda salah");
        }
    }

    public void menabung (int jumlah) {
        if (jumlah > 0) {
            this.koin += jumlah;
            catatKegiatan("penambahan koin sebanyak " + jumlah + " berhasil");
        }
    }

    public void membongkar (int jumlah, String inputPin) {
        if (this.pin.equals(inputPin) && this.koin >= jumlah) {
            this.koin -= jumlah;
            catatKegiatan("anda berhasil membongkar celengan dan mengambil uang sebanyak " + jumlah);
        } else {
            catatKegiatan("anda gagal membongkar celengan! (pin salah/koin tdk mencukupi)");
        }
    }

    private void catatKegiatan (String pesan) {
        System.out.println("[LOG]: " + pesan);
    }
}
