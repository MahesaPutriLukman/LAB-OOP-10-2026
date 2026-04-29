package nomor1;

public class Lingkaran extends BangunDatar{
    double jariJari;

    public Lingkaran(double jariJari){
        this.jariJari = jariJari;
    }

    public double keliling(){
        return 2*Math.PI*jariJari;
    }

    public double luas(){
        return Math.PI*jariJari*jariJari;
    }
}
