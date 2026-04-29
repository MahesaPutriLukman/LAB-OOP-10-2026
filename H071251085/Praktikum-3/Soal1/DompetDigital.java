package Soal1;

class DompetDigital {
    private double saldo;
    private String pin;

    protected String namaPemilik;

    String jenisAkun;

    public DompetDigital(String namaPemilik, String pin) {
        this.namaPemilik = namaPemilik;
        this.pin = pin;
        this.saldo = 0;
        this.jenisAkun = "Basic";
    }

    public String getNamaPemilik() {
        return namaPemilik;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setGantiPin(String pinLama, String pinBaru) {

        if (pin.equals(pinLama) && pinBaru.length() == 6) {
            pin = pinBaru;
            System.out.println("PIN berhasil diganti.");
            catatLog("Ganti PIN berhasil");
        }
        else {
            System.out.println("PIN gagal diganti.");
            catatLog("Ganti PIN gagal");
        }
    }

    public void setor(double uang) {

        if (uang > 0) {
            saldo = saldo + uang;
            System.out.println("Setor sukses: " + uang);
            catatLog("Setor berhasil");
        }
        else {
            System.out.println("Jumlah tidak valid!");
            catatLog("Setor gagal");
        }
    }

    public void tarik(double uang, String inputPin) {

        if (!pin.equals(inputPin)) {
            System.out.println("PIN salah!");
            catatLog("Tarik gagal - PIN salah");
        }

        else if (uang > saldo) {
            System.out.println("Saldo tidak cukup!");
            catatLog("Tarik gagal - saldo kurang");
        }

        else {
            saldo = saldo - uang;
            System.out.println("Tarik sukses: " + uang);
            catatLog("Tarik berhasil");
        }
    }

    private void catatLog(String pesan) {
        System.out.println("[Riwayat] " + pesan + "\n");
    }
}