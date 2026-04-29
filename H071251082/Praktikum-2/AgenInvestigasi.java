public class AgenInvestigasi {
    String nama;
    String keahlian;
    KasusMisteri kasusTujuan;

    public AgenInvestigasi() {
        this.nama = "Anonim";
        this.keahlian = "Umum";
    }

    public AgenInvestigasi(String nama, String keahlian) {
        this.nama = nama;
        this.keahlian = keahlian;
    }

    public void tampilkanProfil() {
        System.out.println("Nama     : " + this.nama); 
        System.out.println("Keahlian : " + this.keahlian);
    }

    public void detailAlat(int nomor, AlatInvestigasi detail) {
        System.out.println(nomor + ". " + detail.namaAlat + " untuk " + detail.fungsiAlat + ".");
    }

    public void amankanTKP(KasusMisteri kasus){
        this.kasusTujuan = kasus;
        System.out.println("[ OPERASI ]");
        System.out.println();
        System.out.println(this.nama + " melakukan pengecekan TKP sekaligus mewawancarai para tersangka.");
        System.out.println(this.nama + " mengunci TKP untuk kasus " + this.kasusTujuan.namaKasus + ".");
        System.out.println(this.nama + " akhirnya keluar dari TKP dengan bukti yang telah rampung.");
    }

    public void konfirmasiPelaku(AgenInvestigasi pelaku){
        System.out.println("[ ARSIP FINAL ]");
        System.out.println();
        System.out.println(this.nama + " telah mengidentifikasi " + pelaku.nama + " sebagai pelaku pada kasus ini.");
        System.out.println("Pelaku merupakan seorang mantan agen dengan keahlian: " + pelaku.keahlian + ".");
        System.out.println(this.nama + " menutup file. Keadilan telah ditegakkan.");
    }
    
    public void laporanFinal(AgenInvestigasi laporan){
        System.out.println(this.nama + " mematikan senternya. Kasus ini dengan resmi berakhir.");
    }
}