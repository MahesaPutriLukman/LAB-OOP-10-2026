package soal1;
public class Lingkaran extends BangunDatar {
    void hitung(double r) {
        this.luas = Math.PI * r * r;
        this.keliling = 2 * Math.PI * r;
        System.out.println("Luas lingkaran: " + luas);
        System.out.println("Keliling lingkaran: " + keliling);
    }
}