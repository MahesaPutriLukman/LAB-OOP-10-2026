package nomor1;

public class Tabung extends BangunRuang {
    double jariJari;
    double tinggi;

    public Tabung(double jariJari, double tinggi){
        this.jariJari = jariJari;
        this.tinggi = tinggi;
    }

    public double luasPermukaan(){
        return 2*Math.PI*jariJari*(jariJari+tinggi);
    }

    public double volume(){
        return Math.PI*jariJari*jariJari*tinggi;
    }
}