package soal2;

// import library concurrent dan collection
import java.util.concurrent.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // daftar nama dokumen yang akan diproses
        String[] documents = {
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

        // membuat object processor untuk memproses dokumen
        DataProcessor processor = new DataProcessor();

        // membuat thread pool berisi 4 thread
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // map thread-safe untuk menyimpan hasil jumlah kata
        ConcurrentHashMap<String, Integer> results =
                new ConcurrentHashMap<>();

        // list thread-safe untuk menyimpan ringkasan hasil
        List<DocumentResult> summary =
                Collections.synchronizedList(new ArrayList<>());

        // sinkronisasi untuk menunggu semua thread selesai
        CountDownLatch latch =
                new CountDownLatch(documents.length);

        // tampilan awal program
        System.out.println("=== MULAI PROCESSING ===\n");

        // looping semua dokumen
        for (String doc : documents) {

            // menjalankan task ke thread pool
            executor.execute(() -> {

                // mencatat waktu mulai
                long start = System.currentTimeMillis();

                // memproses dokumen
                int wordCount = processor.process(doc);

                // mencatat waktu selesai
                long end = System.currentTimeMillis();

                // menghitung lama proses
                long duration = end - start;

                // menyimpan hasil jumlah kata ke map
                results.put(doc, wordCount);

                // menyimpan detail hasil ke list summary
                summary.add(new DocumentResult(
                        doc,
                        Thread.currentThread().getName(),
                        wordCount,
                        duration
                ));

                // menampilkan monitoring realtime
                System.out.println(
                        "[" + Thread.currentThread().getName() + "] "
                                + "Selesai memproses "
                                + doc
                                + " (" + wordCount + " kata)"
                );

                // mengurangi jumlah latch
                latch.countDown();
            });
        }

        // menunggu sampai semua thread selesai
        latch.await();

        // menghentikan executor
        executor.shutdown();

        // tampilan hasil akhir
        System.out.println("\n=== HASIL AKHIR ===\n");

        // membuat header tabel
        System.out.printf(
                "%-15s %-20s %-15s %-10s\n",
                "Dokumen",
                "Thread",
                "Jumlah Kata",
                "Durasi"
        );

        // garis pemisah tabel
        System.out.println(
                "--------------------------------------------------------------"
        );

        // variabel total kata
        int totalWords = 0;

        // variabel total durasi
        long totalDuration = 0;

        // looping semua hasil summary
        for (DocumentResult r : summary) {

            // menampilkan isi tabel
            System.out.printf(
                    "%-15s %-20s %-15d %-10d\n",
                    r.documentName,
                    r.threadName,
                    r.wordCount,
                    r.duration
            );

            // menambahkan total kata
            totalWords += r.wordCount;

            // menambahkan total durasi
            totalDuration += r.duration;
        }

        // menghitung rata-rata durasi
        double average =
                (double) totalDuration / summary.size();

        // menampilkan total kata
        System.out.println("\nTotal Kata : " + totalWords);

        // menampilkan rata-rata durasi
        System.out.println(
                "Rata-rata Durasi : "
                        + average
                        + " ms"
        );
    }
}