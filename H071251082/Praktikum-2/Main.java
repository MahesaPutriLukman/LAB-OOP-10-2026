public class Main {
    public static void main(String[] args) {
        AgenInvestigasi agen = new AgenInvestigasi("Jali", "Analisa bukti secara fisik dan melalui interogasi" );
        AgenInvestigasi pelaku = new AgenInvestigasi("Mamat", "Infiltrasi & Sabotase");

        AlatInvestigasi buku = new AlatInvestigasi("Buku", "mencatat obrolan dengan orang yang diinterogasi");
        AlatInvestigasi lup = new AlatInvestigasi("Lup", "menemukan hal-hal kecil di TKP yang dapat membantu proses investigasi");
        AlatInvestigasi serbukSidikJari = new AlatInvestigasi("Serbuk Sidik Jari", "mengecek sidik jari siapa yang pernah menyentuh barang bukti");
        AlatInvestigasi senterUltraviolet = new AlatInvestigasi("Senter Ultraviolet", "mendeteksi bukti fisik yang tidak kasat mata");

        KasusMisteri wasiat = new KasusMisteri("Wasiat Tengah Malam", "Sangat Tinggi");

        System.out.println("===========================================================================================");
        System.out.println("                   [ FILE LENGKAP DAN RAHASIA KASUS WASIAT TENGAH MALAM ]                  ");
        System.out.println("===========================================================================================");
        System.out.println("                            [ HALAMAN 1 : PROFIL AGEN ]");
        System.out.println();
        agen.tampilkanProfil();
        System.out.println("Alat yang Digunakan pada Proses Penyelidikan :");
        agen.detailAlat(1, buku);
        agen.detailAlat(2, lup);
        agen.detailAlat(3, serbukSidikJari);
        agen.detailAlat(4, senterUltraviolet);
        System.out.println("==========================================================================================");
        System.out.println("                            [ HALAMAN 2 : PROFIL KASUS ]");
        System.out.println();
        wasiat.tampilkanInfo();
        System.out.println("==========================================================================================");
        System.out.println("                          [ HALAMAN 3 : EKSEKUSI LAPANGAN ]");
        System.out.println();
        agen.amankanTKP(wasiat); 
        System.out.println();
        System.out.println("[ REVIEW BUKTI LAPANGAN ]");
        System.out.println();
        agen.detailAlat(1, lup);
        System.out.println("   >> Catatan: Serat kain sutra yang menyangkut di sudut meja.");
        System.out.println();
        agen.detailAlat(2, senterUltraviolet);
        System.out.println("   >> Catatan: Jejak bercak menunjukkan pelaku kabur lewat balkon.");
        System.out.println();
        agen.detailAlat(3, serbukSidikJari);
        System.out.println("   >> Catatan: Sidik jari pada botol racun di atas meja.");
        System.out.println();
        agen.detailAlat(4, buku);
        System.out.println("   >> Catatan: Semua bukti mengarah kepada satu profil yang sangat terlatih");
        System.out.println();
        agen.konfirmasiPelaku(pelaku);
        System.out.println();
        System.out.println("[ LAPORAN FINAL ]");
        System.out.println();
        agen.laporanFinal(pelaku);
        System.out.println("==========================================================================================");
    }
}