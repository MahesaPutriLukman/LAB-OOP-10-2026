package nomor1;

public class Persegi extends BangunDatar{
    double sisi;

    public Persegi(double sisi){
        this.sisi = sisi;
    }

    public double keliling(){
        return 4*sisi;
    }

    public double luas(){
        return sisi*sisi;
    }
}

