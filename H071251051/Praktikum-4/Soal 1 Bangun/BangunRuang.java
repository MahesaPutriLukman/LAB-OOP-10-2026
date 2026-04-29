public class BangunRuang {

    protected String nama;

    public BangunRuang(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public double hitungLuas() {
        return 0;
    }

    public double hitungVolume() {
        return 0;
    }

    public void tampilkanHasil() {
        System.out.println("Luas permukaan " + nama + " : " + hitungLuas());
        System.out.println("Volume "         + nama + " : " + hitungVolume());
    }
}