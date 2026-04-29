package soal1;
public class PersegiPanjang extends BangunDatar {
    void hitung(double p, double l) {
        this.luas = p * l;
        this.keliling = 2 * (p + l);
        System.out.println("Luas persegi panjang: " + luas);
        System.out.println("Keliling persegi panjang: " + keliling);
    }
}