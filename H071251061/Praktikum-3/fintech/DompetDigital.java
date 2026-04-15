package fintech;

public class DompetDigital{
    private double saldo;
    private String pin;
    protected String namaNasabah;
    String noRek;

    public DompetDigital(String noRek, String namaNasabah, String pinAwal){
        this.noRek= noRek;
        this.namaNasabah = namaNasabah;
        this.pin = pinAwal;
        this.saldo = 0;
    }

    public String getNamaNasabah(){
        return namaNasabah;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setPin(String pinLama, String pinBaru){
        if (this.pin.equals(pinLama) && pinBaru.length() >= 6) {
            this.pin = pinBaru;
            catatLog("PIN Baru Berhasil dibuat");
        }else{
        catatLog("Gagal Memperbarui PIN");
        }
    }

    public void setorTunai (double jumlah){
        if (jumlah > 0) {
            this.saldo += jumlah;
            catatLog("Setor Tunai Berhasil: " + jumlah);
        }else{
            catatLog("Setor Tunai Gagal: Nominal Invalid");
        }
    }
    public void tarikTunai(double jumlah, String inputPin) {
        if (this.pin.equals(inputPin)) {
            if (this.saldo >= jumlah && jumlah >= 0) {
                this.saldo -= jumlah;
                catatLog("Tarik Tunai Berhasil: -" + jumlah);
            } else {
            catatLog("Tarik Tunai Gagal: Saldo Tidak Mencukupi atau Nominal Tidak Valid");
            }
        }else {
        catatLog("Tarik Tunai Gagal: PIN Salah");
        }
    }

    public void catatLog(String pesan){
        System.out.println("[System Log]" + pesan);
    }
}