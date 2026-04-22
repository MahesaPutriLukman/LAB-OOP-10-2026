package nomor1;

public class Balok extends BangunRuang {
    double panjang;
    double lebar;
    double tinggi;

    public Balok(double panjang, double lebar, double tinggi){
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    public double luasPermukaan(){
        return 2*(panjang*lebar) + 2*(lebar*tinggi) + 2*(panjang*tinggi);
    }

    public double volume(){
        return panjang*lebar*tinggi;
    }
}