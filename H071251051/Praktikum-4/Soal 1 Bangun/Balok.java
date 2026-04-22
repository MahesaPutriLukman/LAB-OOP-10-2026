public class Balok extends BangunRuang {

    private double panjang, lebar, tinggi;

    public Balok(double panjang, double lebar, double tinggi) {
        super("Balok");
        this.panjang = panjang;
        this.lebar   = lebar;
        this.tinggi  = tinggi;
    }

    public double hitungLuas() {
        return 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
    }

    public double hitungVolume() {
        return panjang * lebar * tinggi;
    }
}