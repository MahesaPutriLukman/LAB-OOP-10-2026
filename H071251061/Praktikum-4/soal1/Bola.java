package soal1;
public class Bola extends BangunRuang {
    void hitung(double r) {
        this.volume = (4.0/3.0) * Math.PI * Math.pow(r, 3);
        this.luasPermukaan = 4 * Math.PI * (r * r);
        System.out.println("Volume bola: " + volume);
        System.out.println("Luas permukaan bola: " + luasPermukaan);
    }
}