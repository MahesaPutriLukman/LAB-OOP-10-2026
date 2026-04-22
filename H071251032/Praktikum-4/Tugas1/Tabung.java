public class Tabung extends BangunRuang {
    private double r, t;
    public Tabung(double r, double t) { this.r = r; this.t = t; }
    public double luas() { return 2 * Math.PI * r * (r + t); }
    public double volume() { return Math.PI * r * r * t; }
}