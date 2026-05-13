package soal1;

// import library untuk thread pool dan pengaturan thread
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        // membuat objek gudang dengan kapasitas awal 20
        Gudang gudang = new Gudang(20);

        // membuat thread pool dengan maksimal 6 thread berjalan bersamaan
        ExecutorService executor = Executors.newFixedThreadPool(6);

        // menjalankan 2 thread pemasok
        executor.execute(new Pemasok(gudang));
        executor.execute(new Pemasok(gudang));

        // menjalankan 3 thread kurir
        executor.execute(new Kurir(gudang));
        executor.execute(new Kurir(gudang));
        executor.execute(new Kurir(gudang));

        // menjalankan thread monitoring untuk memantau gudang
        executor.execute(new Monitoring(gudang));

        try {

            // program utama berhenti sementara selama 15 detik
            Thread.sleep(15000);

        } catch (InterruptedException e) {

            // menangani error jika thread terganggu
            e.printStackTrace();
            return;
        }

        // menghentikan semua thread yang sedang berjalan
        executor.shutdownNow();

        try {

            // menunggu maksimal 5 detik sampai semua thread selesai
            if (executor.awaitTermination(5, TimeUnit.SECONDS)) {

                // jika semua thread berhasil berhenti
                System.out.println("Semua thread berhasil dihentikan.");

            } else {

                // jika masih ada thread yang berjalan
                System.out.println("Masih ada thread yang berjalan.");
            }

        } catch (InterruptedException e) {

            // menangani error saat menunggu penghentian thread
            e.printStackTrace();
        }

        // tanda bahwa program selesai dijalankan
        System.out.println("Program selesai.");
    }
}