import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main2{
    public static void main(String[] args) {
        int totalDokumen = 10;

        DataProcessor processor = new DataProcessor();
        ConcurrentHashMap<String, DetailHasil> hasilMap = new ConcurrentHashMap<>();

        CountDownLatch latch = new CountDownLatch(totalDokumen);
        ExecutorService executor = Executors.newFixedThreadPool(4);

        System.out.println("=== Memulai Indexing " + totalDokumen + " Dokumen ===");

        for (int i = 1; i <= totalDokumen; i++) {
            String namaDoc = "Dokumen_" + i + ".txt";
            executor.submit(new IndexTask(namaDoc, hasilMap, latch, processor));
        }

        try {
            latch.await();

            executor.shutdown();

            System.out.println("\n=== Hasil Akhir Proses Indexing ===");
            System.out.printf("%-15s | %-20s | %-12s | %-12s\n", "Nama Dokumen", "Thread Penanganan", "Durasi", "Jumlah Kata");
            System.out.println("---------------------------------------------------------------------");

            int totalKataKeseluruhan = 0;
            long totalWaktuPemrosesan = 0;

            for (int i = 1; i <= totalDokumen; i++) {
                String namaDoc = "Dokumen_" + i + ".txt";
                DetailHasil detail = hasilMap.get(namaDoc);
                
                if (detail != null) {
                    System.out.printf("%-15s | %-20s | %-9d ms | %-12d\n", 
                        namaDoc, detail.namaThread, detail.durasi, detail.jumlahKata);
                    
                    totalKataKeseluruhan += detail.jumlahKata;
                    totalWaktuPemrosesan += detail.durasi;
                }
            }

            System.out.println("---------------------------------------------------------------------");
            System.out.println("Total Kata Keseluruhan   : " + totalKataKeseluruhan + " kata");

            long rataRataWaktu = totalWaktuPemrosesan / totalDokumen;
            System.out.println("Rata-rata Waktu Proses   : " + rataRataWaktu + " ms per dokumen");

        } catch (InterruptedException e) {
            System.out.println("Proses utama terputus secara paksa!");
            Thread.currentThread().interrupt();
        }
    }
}