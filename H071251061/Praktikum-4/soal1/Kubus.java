package soal1;
public class Kubus extends BangunRuang {
    void hitung(double s) {
        this.volume = Math.pow(s, 3);
        this.luasPermukaan = 6 * (s * s);
        System.out.println("Volume kubus: " + volume);
        System.out.println("Luas permukaan kubus: " + luasPermukaan);
    }
}