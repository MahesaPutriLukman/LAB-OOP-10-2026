import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class DocumentTask  implements Runnable{
    
    private String doc;
    private DataProcessor processor;
    private ConcurrentHashMap<String, Integer> results;
    private List<DocumentResult> summary;
    private CountDownLatch latch;

    public DocumentTask(String doc,
                        DataProcessor processor,
                        ConcurrentHashMap<String, Integer> results,
                        List<DocumentResult> summary,
                        CountDownLatch latch) {
        this.doc = doc;
        this.processor = processor;
        this.results = results;
        this.summary = summary;
        this.latch = latch;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

        int wordCount = processor.process(doc);

        long end = System.currentTimeMillis();
        long duration = end - start;

        // simpan hasil
        results.put(doc, wordCount);

        // simpan summary
        summary.add(new DocumentResult(
                doc,
                Thread.currentThread().getName(),
                wordCount,
                duration
        ));

        // tampilkan progress
        System.out.println(
                "[" + Thread.currentThread().getName() + "] " +
                "Selesai memproses " +
                doc +
                " (" + wordCount + " kata)"
        );

        // kurangi latch
        latch.countDown();
    }
}
