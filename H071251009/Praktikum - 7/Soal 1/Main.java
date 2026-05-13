import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Gudang gudang = new Gudang(20);
        ExecutorService executor = Executors.newFixedThreadPool(6);

        executor.execute(new Pemasok(gudang));
        executor.execute(new Pemasok(gudang));

        executor.execute(new Kurir(gudang));
        executor.execute(new Kurir(gudang));
        executor.execute(new Kurir(gudang));

        executor.execute(new Monitoring(gudang));

        try {
            Thread.sleep(15000);

        } catch (InterruptedException e) {
            e.printStackTrace();
            return;
        }
        executor.shutdownNow();
        try {

            if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Semua thread berhasil dihentikan.");
            } else {
                System.out.println("Masih ada thread yang berjalan.");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Program selesai.");
    }
}
