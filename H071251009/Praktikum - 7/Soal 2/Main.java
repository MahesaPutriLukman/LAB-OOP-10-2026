import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // daftar dokumen
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

        DataProcessor processor = new DataProcessor();

        ExecutorService executor = Executors.newFixedThreadPool(4);

        ConcurrentHashMap<String, Integer> results =
                new ConcurrentHashMap<>();

        List<DocumentResult> summary =
                Collections.synchronizedList(new ArrayList<>());

        CountDownLatch latch =
                new CountDownLatch(documents.length);

        System.out.println("=== MULAI PROCESSING ===\n");

        // kirim setiap dokumen ke thread pool
        for (String doc : documents) {
            executor.execute(
                    new DocumentTask(
                            doc,
                            processor,
                            results,
                            summary,
                            latch
                    )
            );
        }

        // tunggu semua selesai
        latch.await();

        // matikan executor
        executor.shutdown();

        System.out.println("\n=== HASIL AKHIR ===\n");

        System.out.printf(
                "%-15s %-20s %-15s %-10s\n",
                "Dokumen",
                "Thread",
                "Jumlah Kata",
                "Durasi"
        );

        System.out.println(
                "--------------------------------------------------------------"
        );

        int totalWords = 0;
        long totalDuration = 0;

        for (DocumentResult r : summary) {
            System.out.printf(
                    "%-15s %-20s %-15d %-10d\n",
                    r.documentName,
                    r.threadName,
                    r.wordCount,
                    r.duration
            );

            totalWords += r.wordCount;
            totalDuration += r.duration;
        }

        double average =
                (double) totalDuration / summary.size();

        System.out.println("\nTotal Kata : " + totalWords);
        System.out.println("Rata-rata Durasi : " + average + " ms");
    }
}
