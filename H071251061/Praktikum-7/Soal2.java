import java.util.*;
import java.util.concurrent.*;

class ResultData {
    String threadName;
    long duration;
    int wordCount;

    public ResultData(String threadName, long duration, int wordCount) {
        this.threadName = threadName;
        this.duration = duration;
        this.wordCount = wordCount;
    }
}

class DataProcessor {
    public int process(String fileName) throws InterruptedException {
        Random random = new Random();
        int sleepTime = 500 + random.nextInt(1501);
        Thread.sleep(sleepTime);
        return 50 + random.nextInt(200);
    }
}

public class Soal2 {
    public static void main(String[] args) {
        int totalDocuments = 10;
        ExecutorService executor = Executors.newFixedThreadPool(4);
        CountDownLatch latch = new CountDownLatch(totalDocuments);
        ConcurrentHashMap<String, ResultData> results = new ConcurrentHashMap<>();
        DataProcessor processor = new DataProcessor();

        long startTime = System.currentTimeMillis();

        for (int i = 1; i <= totalDocuments; i++) {
            final String docName = "Dokumen_" + (char)('A' + (i - 1)) + ".txt";
            executor.execute(() -> {
                try {
                    long taskStartTime = System.currentTimeMillis();
                    int words = processor.process(docName);
                    long duration = System.currentTimeMillis() - taskStartTime;

                    results.put(docName, new ResultData(Thread.currentThread().getName(), duration, words));
                    System.out.println("[" + Thread.currentThread().getName() + "] Selesai memproses " + docName + " (" + words + " kata).");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            });
        }

        try {
            latch.await();
            executor.shutdown();

            System.out.println("\n" + "=".repeat(60));
            System.out.printf("%-15s | %-15s | %-15s\n", "Nama Dokumen", "Thread", "Durasi (ms)");
            System.out.println("-".repeat(60));

            int totalWords = 0;
            long totalDuration = 0;

            for (Map.Entry<String, ResultData> entry : results.entrySet()) {
                ResultData data = entry.getValue();
                System.out.printf("%-15s | %-15s | %-15d\n", entry.getKey(), data.threadName, data.duration);
                totalWords += data.wordCount;
                totalDuration += data.duration;
            }

            System.out.println("-".repeat(60));
            System.out.println("Total Kata Keseluruhan: " + totalWords);
            System.out.printf("Rata-rata Waktu Proses: %.2f ms\n", (double) totalDuration / totalDocuments);
            System.out.println("=".repeat(60));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}