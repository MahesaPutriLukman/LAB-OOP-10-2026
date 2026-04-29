package soal1;
public class Persegi extends BangunDatar {
    void hitung(double s) {
        this.luas = s * s;
        this.keliling = 4 * s;
        System.out.println("Luas persegi: " + luas);
        System.out.println("Keliling persegi: " + keliling);
    }
}