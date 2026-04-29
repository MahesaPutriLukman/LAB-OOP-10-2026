

public class CelenganDigital {
    private int  koin;
    private String pin;
    protected String namaPemilik;
    String tipeCelengan;

    public CelenganDigital(String namaPemilik, String pinAwal, String tipeCelengan){
        this.namaPemilik = namaPemilik;
        this.pin = pinAwal;
        this.tipeCelengan = "sembarang";
        this.koin = 0;
    }

    public String getNamaPemilik(){
        return namaPemilik;
    }

    public void ubahPin(String pinLama, String pinBaru){
        if( this.pin.equals(pinLama)){
            this.pin = pinBaru;
            sysLog("Ubah PIN Berhasil");
        }else{
            sysLog("Gagal Memperbarui PIN");
        }
    }

    public void menabung(int jumlah){
        if (jumlah > 0){
            this.koin += jumlah;
            sysLog("Berhasil Nabung");
        }else {
            sysLog("Gagal Nabung");
        }
    }

    public void bongkar(int jumlah, String inputPin){
        if (this.pin.equals(inputPin)){
            if (this.koin >= jumlah && jumlah >= 0){
                this.koin = jumlah;
                sysLog("Bongkar Berhasil");
            }else {
                sysLog(" Bongkar celengan Gagal");
            }
        }else{
            sysLog("Bongkar celengan Gagal");
        }
    }

    public void sysLog(String pesan){
        System.out.println("[SYSTEM LOG] " + pesan);
    }

}

