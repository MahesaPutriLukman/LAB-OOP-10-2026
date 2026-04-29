public class Kubus extends BangunRuang {
    private double sisi;
    public Kubus(double sisi) { this.sisi = sisi; }
    public double luas() { return 6 * sisi * sisi; }
    public double volume() { return sisi * sisi * sisi; }
}
