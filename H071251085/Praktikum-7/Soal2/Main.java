import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Main {

    public static void main(String[] args)
            throws InterruptedException {

        ExecutorService executor =
                Executors.newFixedThreadPool(4);

        ConcurrentHashMap<String, HasilDokumen>
                hasilMap = new ConcurrentHashMap<>();

                String[] dokumen = {
                                "Dokumen_A.txt",
                                "Dokumen_B.txt",
                                "Dokumen_C.txt",
                                "Dokumen_D.txt",
                                "Dokumen_E.txt",
                                "Dokumen_F.txt",
                                "Dokumen_G.txt",
                                "Dokumen_H.txt",
                                "Dokumen_I.txt",
                                "Dokumen_J.txt"
                        };


        CountDownLatch latch =
                new CountDownLatch(dokumen.length);

        DataProcessor processor =
                new DataProcessor();

        System.out.println(
                "=== MULAI PEMROSESAN ===\n"
        );

        for (String doc : dokumen) {

            executor.execute(() -> {

                try {

                    long start =
                            System.currentTimeMillis();

                    int jumlahKata =
                            processor.process(doc);

                    long end =
                            System.currentTimeMillis();

                    long durasi =
                            end - start;

                    String namaThread =
                            Thread.currentThread().getName();

                    hasilMap.put(doc, new HasilDokumen(doc, namaThread, jumlahKata, durasi));

                    System.out.println( "[" + namaThread + "] " + "Selesai memproses " + doc + " (" + jumlahKata + " kata)");

                } catch (InterruptedException e) {
                    System.out.println(doc + " gagal diproses.");

                } finally {
                        latch.countDown();
                }
                });
        }

        latch.await();

        executor.shutdown();

        System.out.println("\n=== HASIL AKHIR ===");

        System.out.printf("%-20s %-20s %-15s %-15s\n","Nama Dokumen", "Thread", "Jumlah Kata", "Durasi(ms)");

        System.out.println("--------------------------------------------------------------------");

        int totalKata = 0;

        long totalDurasi = 0;

        for (HasilDokumen hasil
                : hasilMap.values()) {

            System.out.printf("%-20s %-20s %-15d %-15d\n", hasil.namaDokumen, hasil.namaThread, hasil.jumlahKata, hasil.durasi);

            totalKata += hasil.jumlahKata;

            totalDurasi += hasil.durasi;
        }

        double rataRata = (double) totalDurasi/ hasilMap.size();

        System.out.println("\nTotal Kata Keseluruhan : " + totalKata);

        System.out.println("Rata-rata Waktu Proses : " + rataRata + " ms");
    }
}