package soal1;
public class Trapesium extends BangunDatar {
    void hitung(double s1, double s2, double s3, double s4, double t) {
        this.luas = 0.5 * (s1 + s2) * t;
        this.keliling = s1 + s2 + s3 + s4;
        System.out.println("Luas trapesium: " + luas);
        System.out.println("Keliling trapesium: " + keliling);
    }
}