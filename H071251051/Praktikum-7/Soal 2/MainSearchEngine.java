import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MainSearchEngine {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("  HIGH-PERFORMANCE DATA INDEXER");
        System.out.println("  The Search Engine Core");
        System.out.println("==============================================");

        // ---- Input dari user ----
        System.out.print("Masukkan jumlah thread worker (misal: 4)         : ");
        int jumlahThread = scanner.nextInt();

        System.out.print("Masukkan jumlah dokumen yang diproses (min 10)   : ");
        int jumlahDokumen = Math.max(scanner.nextInt(), 10); 

        scanner.nextLine(); 

        System.out.println("\nPilih nama dokumen:");
        System.out.println("  1. Nama default (Dokumen_A.txt, Dokumen_B.txt, ...)");
        System.out.println("  2. Masukkan nama sendiri");
        System.out.print("Pilihan (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        // ---- Buat daftar nama dokumen ----
        List<String> daftarDokumen = new ArrayList<>();

        if (pilihan == 2) {
            System.out.println("Masukkan " + jumlahDokumen + " nama dokumen (satu per baris):");
            for (int i = 0; i < jumlahDokumen; i++) {
                System.out.print("  Dokumen " + (i + 1) + ": ");
                String nama = scanner.nextLine().trim();
                daftarDokumen.add(nama.isEmpty() ? "Dokumen_" + (i + 1) + ".txt" : nama);
            }
        } else {
            String[] huruf = {
                "A","B","C","D","E","F","G","H","I","J",
                "K","L","M","N","O","P","Q","R","S","T",
                "U","V","W","X","Y","Z"
            };
            for (int i = 0; i < jumlahDokumen; i++) {
                String nama = i < huruf.length
                        ? "Dokumen_" + huruf[i] + ".txt"
                        : "Dokumen_" + (i + 1) + ".txt";
                daftarDokumen.add(nama);
            }
        }

        System.out.println("\nMemulai pengindeksan " + jumlahDokumen
                + " dokumen dengan " + jumlahThread + " thread...");
        System.out.println("----------------------------------------------\n");

        DataProcessor processor = new DataProcessor();

        // Map yang aman dipakai bersama banyak thread
        ConcurrentHashMap<String, Integer> hasilIndex = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, String>  infoThread = new ConcurrentHashMap<>();
        ConcurrentHashMap<String, Long>    durasi     = new ConcurrentHashMap<>();

        // CountDownLatch dimulai dari jumlahDokumen
        CountDownLatch latch = new CountDownLatch(jumlahDokumen);

        AtomicInteger jumlahSelesai = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(jumlahThread);

        long waktuMulai = System.currentTimeMillis();

        for (String namaFile : daftarDokumen) {
            executor.submit(new IndexingTask(
                    namaFile, processor,
                    hasilIndex, infoThread, durasi,
                    latch, jumlahSelesai, jumlahDokumen
            ));
        }

        System.out.println("  [MAIN] Menunggu semua dokumen selesai diproses...\n");
        latch.await(); 

        long totalWaktu = System.currentTimeMillis() - waktuMulai;

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        HasilRingkasan.cetak(daftarDokumen, hasilIndex, infoThread, durasi,
                             jumlahThread, totalWaktu);

        scanner.close();
    }
}
