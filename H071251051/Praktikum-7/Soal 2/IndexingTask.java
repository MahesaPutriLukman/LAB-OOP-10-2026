import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class IndexingTask implements Runnable {

    private final String namaFile;
    private final DataProcessor processor;

    private final ConcurrentHashMap<String, Integer> hasilIndex; 
    private final ConcurrentHashMap<String, String>  infoThread; 
    private final ConcurrentHashMap<String, Long>    durasi;     

    private final CountDownLatch latch;        
    private final AtomicInteger  jumlahSelesai; 
    private final int            totalDokumen;  

    public IndexingTask(String namaFile,
                        DataProcessor processor,
                        ConcurrentHashMap<String, Integer> hasilIndex,
                        ConcurrentHashMap<String, String>  infoThread,
                        ConcurrentHashMap<String, Long>    durasi,
                        CountDownLatch latch,
                        AtomicInteger  jumlahSelesai,
                        int            totalDokumen) {
        this.namaFile      = namaFile;
        this.processor     = processor;
        this.hasilIndex    = hasilIndex;
        this.infoThread    = infoThread;
        this.durasi        = durasi;
        this.latch         = latch;
        this.jumlahSelesai = jumlahSelesai;
        this.totalDokumen  = totalDokumen;
    }

    @Override
    public void run() {
        String namaThread = Thread.currentThread().getName();
        long mulai = System.currentTimeMillis();

        try {
            int jumlahKata  = processor.process(namaFile);
            long lamaProses = System.currentTimeMillis() - mulai;

            hasilIndex.put(namaFile, jumlahKata);
            infoThread.put(namaFile, namaThread);
            durasi.put(namaFile, lamaProses);

            int urutan = jumlahSelesai.incrementAndGet();
            System.out.printf("  [%s] Selesai memproses %-20s (%4d kata) | %4d ms | [%d/%d]%n",
                    namaThread, namaFile, jumlahKata, lamaProses, urutan, totalDokumen);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("  [" + namaThread + "] Diinterrupt saat memproses " + namaFile);
        } finally {
            latch.countDown();
        }
    }
}
