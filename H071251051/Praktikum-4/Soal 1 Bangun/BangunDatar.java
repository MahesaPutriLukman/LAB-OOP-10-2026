public class BangunDatar {

    protected String nama;

    public BangunDatar(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public double hitungLuas() {
        return 0;
    }

    public double hitungKeliling() {
        return 0;
    }

    public void tampilkanHasil() {
        System.out.println("Luas " + nama + "     : " + hitungLuas());
        System.out.println("Keliling " + nama + " : " + hitungKeliling());
    }
}