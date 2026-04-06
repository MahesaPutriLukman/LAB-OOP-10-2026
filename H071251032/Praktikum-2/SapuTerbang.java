package QuidditchCompetition;

public class SapuTerbang {
    String merek;
    int kecepatan;

    // Constructor untuk membuat objek sapu
    public SapuTerbang(String merek, int kecepatan) {
        this.merek = merek;
        this.kecepatan = kecepatan;
    }

    public void infoSapu() {
        System.out.println("Sapu Terbang: " + merek + " | Kecepatan Sapu: " + kecepatan);
    }
}
