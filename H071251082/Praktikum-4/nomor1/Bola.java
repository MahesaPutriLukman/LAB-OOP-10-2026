package nomor1;

public class Bola extends BangunRuang {
    double jariJari;

    public Bola(double jariJari){
        this.jariJari = jariJari;
    }

    public double luasPermukaan(){
        return 4*Math.PI*jariJari*jariJari;
    }

    public double volume(){
        return (4*Math.PI*jariJari*jariJari*jariJari)/3;
    }
}