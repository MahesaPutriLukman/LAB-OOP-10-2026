import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

class IndexTask implements Runnable {
    String namaDokumen;
    ConcurrentHashMap<String, DetailHasil> hasilMap;
    CountDownLatch latch;
    DataProcessor processor;

    IndexTask(String namaDokumen, ConcurrentHashMap<String, DetailHasil> hasilMap, CountDownLatch latch, DataProcessor processor) {
        this.namaDokumen = namaDokumen;
        this.hasilMap = hasilMap;
        this.latch = latch;
        this.processor = processor;
    }

    @Override
    public void run() {
        long waktuMulai = System.currentTimeMillis();
        String namaThread = Thread.currentThread().getName();

        try {
            int jumlahKata = processor.process(namaDokumen);

            long waktuSelesai = System.currentTimeMillis();
            long durasi = waktuSelesai - waktuMulai;

            hasilMap.put(namaDokumen, new DetailHasil(jumlahKata, namaThread, durasi));

            System.out.println("[" + namaThread + "] Selesai memproses " + namaDokumen + " (" + jumlahKata + " kata).");

        } catch (InterruptedException e) {
            System.out.println("[" + namaThread + "] Gagal memproses " + namaDokumen);
            Thread.currentThread().interrupt();
        } finally {
            latch.countDown();
        }
    }
}