package nomor1;

public class Kubus extends BangunRuang {
    double sisi;
    public Kubus(double sisi){
        this.sisi = sisi;
    }

    public double luasPermukaan(){
        return 6*sisi*sisi;
    }

    public double volume(){
        return sisi*sisi*sisi;
    }
}
