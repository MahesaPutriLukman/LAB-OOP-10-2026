public class Bola extends BangunRuang {

    private double jariJari;

    public Bola(double jariJari) {
        super("Bola");
        this.jariJari = jariJari;
    }

    public double hitungLuas() {
        return 4 * Math.PI * jariJari * jariJari;
    }

    public double hitungVolume() {
        return (4.0 / 3.0) * Math.PI * jariJari * jariJari * jariJari;
    }
}