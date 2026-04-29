package soal1;
public class Balok extends BangunRuang {
    void hitung(double p, double l, double t) {
        this.volume = p * l * t;
        this.luasPermukaan = 2 * ((p * l) + (p * t) + (l * t));
        System.out.println("Volume balok: " + volume);
        System.out.println("Luas permukaan balok: " + luasPermukaan);
    }
}