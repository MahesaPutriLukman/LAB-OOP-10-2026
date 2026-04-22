package soal1;
public class Tabung extends BangunRuang {
    void hitung(double r, double t) {
        this.volume = Math.PI * (r * r) * t;
        this.luasPermukaan = 2 * Math.PI * r * (r + t);
        System.out.println("Volume tabung: " + volume);
        System.out.println("Luas permukaan tabung: " + luasPermukaan);
    }
}