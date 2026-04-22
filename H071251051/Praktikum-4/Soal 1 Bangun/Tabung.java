public class Tabung extends BangunRuang {

    private double jariJari, tinggi;

    public Tabung(double jariJari, double tinggi) {
        super("Tabung");
        this.jariJari = jariJari;
        this.tinggi   = tinggi;
    }

    public double hitungLuas() {
        return 2 * Math.PI * jariJari * (jariJari + tinggi);
    }

    public double hitungVolume() {
        return Math.PI * jariJari * jariJari * tinggi;
    }
}