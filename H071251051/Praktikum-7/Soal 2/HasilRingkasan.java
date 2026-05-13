import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class HasilRingkasan {

    public static void cetak(List<String>                    daftarDokumen,
                              ConcurrentHashMap<String, Integer> hasilIndex,
                              ConcurrentHashMap<String, String>  infoThread,
                              ConcurrentHashMap<String, Long>    durasi,
                              int jumlahThread,
                              long totalWaktu) {

        System.out.println("\n==============================================");
        System.out.println("      HASIL AKHIR - TABEL RINGKASAN");
        System.out.println("==============================================");

        // Header tabel
        System.out.printf("%-22s %-20s %-12s %s%n",
                "Nama Dokumen", "Thread", "Durasi (ms)", "Jumlah Kata");
        System.out.println("-".repeat(68));

        long totalKata   = 0;
        long totalDurasi = 0;

        // Cetak satu baris per dokumen
        for (String namaFile : daftarDokumen) {
            int    kata   = hasilIndex.getOrDefault(namaFile, 0);
            String thread = infoThread.getOrDefault(namaFile, "?");
            long   dur    = durasi.getOrDefault(namaFile, 0L);

            System.out.printf("%-22s %-20s %-12d %d%n",
                    namaFile, thread, dur, kata);

            totalKata   += kata;
            totalDurasi += dur;
        }

        System.out.println("-".repeat(68));

        // Ringkasan bawah
        int    jumlahDok  = daftarDokumen.size();
        double rataRata   = jumlahDok > 0 ? (double) totalDurasi / jumlahDok : 0;

        System.out.printf("%nTotal Kata Seluruh Dokumen : %d kata%n", totalKata);
        System.out.printf("Rata-rata Waktu Pemrosesan : %.1f ms per dokumen%n", rataRata);
        System.out.printf("Total Waktu Sistem         : %d ms%n", totalWaktu);
        System.out.printf("Jumlah Thread Worker       : %d thread%n", jumlahThread);
        System.out.printf("Jumlah Dokumen Diproses    : %d dokumen%n", jumlahDok);
        System.out.println("==============================================");
    }
}
