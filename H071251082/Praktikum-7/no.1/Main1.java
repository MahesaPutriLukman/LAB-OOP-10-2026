import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Main1 {
    public static void main(String[] args) {
        Gudang gudang = new Gudang(20);

        ExecutorService executor = Executors.newFixedThreadPool(6);

        System.out.println("=== Sistem Gudang Mulai Beroperasi ===");

        executor.submit(new Pemasok(gudang, "Pemasok-A"));
        executor.submit(new Pemasok(gudang, "Pemasok-B"));
        executor.submit(new Kurir(gudang, "Kurir-A"));
        executor.submit(new Kurir(gudang, "Kurir-B"));
        executor.submit(new Kurir(gudang, "Kurir-C"));
        executor.submit(new Monitoring(gudang));

        try {
            Thread.sleep(15000);

            System.out.println("\n=== Waktu Habis (15 Detik). Memulai Shutdown... ===");

            executor.shutdown(); 

            executor.shutdownNow();

            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Peringatan: Beberapa thread tidak dapat dihentikan.");
            } else {
                System.out.println("Sistem Berhasil Dimatikan dengan Aman.");
            }

        } catch (InterruptedException e) {
            System.out.println("Main thread terganggu!");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}