package Soal2;

import java.util.concurrent.*; //digunakan untuk ExecutorService (Dengan 4 thread, program bisa memproses 4 dokumen sekaligus), 
// CountDownLatch untuk sinkronisasi (Program utama tidak boleh menampilkan tabel hasil sebelum semua (10 dokumen) selesai diproses.), 
// dan ConcurrentHashMap untuk mencegah data hilang atau rusak kalau ada dua thread yang mencoba menulis di waktu yang persis sama.

import java.util.*; //digunakan untuk Random (Simulasi jumlah kata yang ditemukan dalam dokumen) dan List, ArrayList, Collections untuk mengelola dan menampilkan hasil dengan rapi.


// Class DataProcessor untuk simulasi pemrosesan dokumen
class DataProcessor {
    private Random random = new Random();

    // Method untuk memproses dokumen, mengembalikan jumlah kata yang ditemukan
    public int process(String fileName) {
        try {
            // Simulasi waktu baca file antara 500ms sampai 2000ms
            int waktuProses = 500 + random.nextInt(1501);
            Thread.sleep(waktuProses); // Simulasi waktu yang dibutuhkan untuk membaca dan memproses dokumen
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Simulasi jumlah kata yang ditemukan (acak antara 50 - 500 kata)
        int jumlahKata = 50 + random.nextInt(451);
        return jumlahKata;
    }
}

// Class pendamping untuk menyimpan detail hasil per dokumen
class HasilIndexing {
    String namaDokumen;
    String namaThread;
    long durasi;
    int jumlahKata;

    public HasilIndexing(String namaDokumen, String namaThread, long durasi, int jumlahKata) {
        this.namaDokumen = namaDokumen;
        this.namaThread = namaThread;
        this.durasi = durasi;
        this.jumlahKata = jumlahKata;
    }
}

public class IndexerApp {
    public static void main(String[] args) {
        // Inisialisasi komponen utama
        DataProcessor processor = new DataProcessor(); // Objek untuk memproses dokumen
        
        // Menggunakan ConcurrentHashMap untuk menyimpan hasil (Thread-Safe)
        // Key: Nama Dokumen, Value: Objek HasilIndexing
        ConcurrentHashMap<String, HasilIndexing> databaseHasil = new ConcurrentHashMap<>();

        // Menggunakan ExecutorService dengan 4 thread tetap
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Menggunakan CountDownLatch untuk 10 dokumen yang berfungsi sebagai penghitung tugas yang harus diselesaikan sebelum program utama melanjutkan untuk menampilkan hasil
        int jumlahDokumen = 10;
        CountDownLatch latch = new CountDownLatch(jumlahDokumen);

        System.out.println("======= Memulai Proses Indexing Data =======");
        long waktuMulaiGlobal = System.currentTimeMillis();

        // Loop untuk mengirim 10 tugas ke thread pool
        for (int i = 1; i <= jumlahDokumen; i++) {
            String namaFile = "Dokumen_" + i + ".txt";

            // metode execute() digunakan untuk mengirim tugas ke thread pool, di mana setiap tugas adalah proses untuk memproses satu dokumen.
            executor.execute(new Runnable() {
                @Override
                public void run() { 
                    long startTime = System.currentTimeMillis(); // Mulai waktu untuk proses dokumen ini
                    
                    // Memproses dokumen
                    int kataDitemukan = processor.process(namaFile); // Memanggil method process() untuk memproses dokumen dan mendapatkan jumlah kata yang ditemukan
                    
                    long endTime = System.currentTimeMillis();
                    long durasiProses = endTime - startTime; 
                    String namaThread = Thread.currentThread().getName(); // Mendapatkan nama thread yang memproses dokumen ini

                    // Simpan ke map kolektif
                    HasilIndexing hasil = new HasilIndexing(namaFile, namaThread, durasiProses, kataDitemukan);
                    databaseHasil.put(namaFile, hasil);

                    // Menampilkan progres real-time
                    System.out.println("[" + namaThread + "] Selesai memproses " + namaFile + " (" + kataDitemukan + " kata)");

                    // Kurangi hitungan latch (menandai satu tugas selesai)
                    latch.countDown();
                }
            });
        }

        try {
            // Program utama menunggu di sini sampai latch mencapai angka 0
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Matikan executor setelah semua selesai
        executor.shutdown();

        long waktuSelesaiGlobal = System.currentTimeMillis();
        long totalWaktuEksekusi = waktuSelesaiGlobal - waktuMulaiGlobal;

        // Tampilkan Output Akhir (Klasemen)
        tampilkanRingkasan(databaseHasil, totalWaktuEksekusi);
    }

    // Method untuk mencetak tabel hasil dan statistik
    public static void tampilkanRingkasan(ConcurrentHashMap<String, HasilIndexing> data, long totalWaktu) {
        System.out.println("\n-------------------------------------------------------------");
        System.out.printf("%-15s | %-15s | %-15s\n", "Nama Dokumen", "Thread", "Durasi (ms)");
        System.out.println("-------------------------------------------------------------");

        int totalKataKeseluruhan = 0;
        long totalDurasiSemuaDoc = 0;

        // Mengambil semua key (nama dokumen) dan mengurutkannya agar rapi
        List<String> sortedKeys = new ArrayList<>(data.keySet());
        Collections.sort(sortedKeys);

        for (String key : sortedKeys) {
            HasilIndexing h = data.get(key);
            System.out.printf("%-15s | %-15s | %-15s\n", h.namaDokumen, h.namaThread, h.durasi + " ms");
            
            totalKataKeseluruhan = totalKataKeseluruhan + h.jumlahKata;
            totalDurasiSemuaDoc = totalDurasiSemuaDoc + h.durasi;
        }

        double rataRataWaktu = (double) totalDurasiSemuaDoc / data.size();

        System.out.println("-------------------------------------------------------------");
        System.out.println("Total Kata Keseluruhan      : " + totalKataKeseluruhan + " kata");
        System.out.printf("Rata-rata Waktu Pemrosesan  : %.2f ms\n", rataRataWaktu);
        System.out.println("Total Durasi Eksekusi Sistem: " + totalWaktu + " ms");
        System.out.println("=============================================================");
    }
}