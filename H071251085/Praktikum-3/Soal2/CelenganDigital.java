package Soal2;
public class CelenganDigital {

    //Atribut private
    private int koin;
    private String pin;

    //Atribut protected
    protected String namaPemilik;

    //Atribut default
    String tipeCelengan;

    public CelenganDigital (String namaPemilik, String pin){
        this.koin = 0;
        this.tipeCelengan = "Ayam Jago";
        this.namaPemilik = namaPemilik;
        this.pin = pin;
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public void setUbahPin (String pinLama, String pinBaru){
        if (this.pin.equals(pinLama)){
            pin = pinBaru;
            log("Pin berhasil diganti");
        }
        else{
            log("Pin gagal diganti");
        }
    }

    public void Nabung(int jumlah) {
        if (jumlah > 0){
            this.koin += jumlah;
            log("Jumlah koin Anda " + jumlah);
        }
        else {
            log("Jumlah harus lebih dari 0");
        }
    }

    public void Bongkar (int jumlah, String inputPin){
        if (this.pin.equals(inputPin) && this.koin >= 0){
            this.koin -= jumlah;
        }
        else{
            log("Pin atau Koin tidak sesuai");
        }
    }

    public void log(String pesan){
        System.out.println("[PESAN] " + pesan + "\n");
    }
}
