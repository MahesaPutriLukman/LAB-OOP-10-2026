public class KasusMisteri {
    String namaKasus;
    String tingkatKesulitan;

    public KasusMisteri() {
        this.namaKasus = "-";
        this.tingkatKesulitan = "Belum diidentifikasi";
    }

    public KasusMisteri(String namaKasus, String tingkatKesulitan) {
        this.namaKasus = namaKasus;
        this.tingkatKesulitan = tingkatKesulitan;
    }

    public void tampilkanInfo() {
        System.out.println("Nama Kasus  : " + this.namaKasus);
        System.out.println("Kesulitan   : " + this.tingkatKesulitan);
        System.out.println("Status      : Terpecahkan");
    }
}