package Soal1;

import java.util.concurrent.ExecutorService; // Menggunakan ExecutorService untuk mengelola thread Pemasok dan Kurir 
import java.util.concurrent.Executors; // Menggunakan Executors untuk membuat thread pool dengan jumlah thread yang sesuai dengan ketentuan (2 Pemasok + 3 Kurir)
import java.util.concurrent.TimeUnit; // Menggunakan TimeUnit untuk mengatur waktu tunggu saat menghentikan thread dengan shutdownNow() dan awaitTermination()

public class Main {
    public static void main(String[] args) {
        // Inisialisasi Gudang dengan kapasitas 50 unit
        Gudang gudangPusat = new Gudang(50);

        // Inisialisasi ExecutorService untuk mengelola Pemasok dan Kurir
        // Sesuai ketentuan: 2 thread Pemasok dan 3 thread Kurir (Total 5)
        ExecutorService executor = Executors.newFixedThreadPool(5);

        // Menjalankan thread Pemasok (2 thread)
        for (int i = 1; i <= 2; i++) {
            executor.execute(new Pemasok(gudangPusat));
        }

        // Menjalankan thread Kurir (3 thread)
        for (int i = 1; i <= 3; i++) {
            executor.execute(new Kurir(gudangPusat));
        }

        // Menjalankan Monitoring di thread terpisah
        Thread threadMonitoring = new Thread(new Monitoring(gudangPusat));
        threadMonitoring.start();

        // perkondisian untuk menjalankan sistem selama 15 detik, setelah itu sistem akan dihentikan secara aman
        try {
            System.out.println("======== Sistem Logistik Dimulai ========");
            Thread.sleep(15000); // 15 detik untuk menjalankan sistem sebelum dihentikan
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Menghentikan semua thread secara aman dengan shutdownNow() untuk Pemasok dan Kurir, serta interrupt() untuk Monitoring 
        System.out.println("\n------ Menghentikan Sistem... ------");
        executor.shutdownNow(); // Menghentikan Pemasok dan Kurir
        threadMonitoring.interrupt(); // Menghentikan Monitoring

        // Menunggu sampai semua thread benar-benar berhenti dengan awaitTermination() untuk memastikan sistem berhenti dengan aman
        try {
            if (executor.awaitTermination(5, TimeUnit.SECONDS)) { // Menunggu maksimal 5 detik untuk memastikan semua thread berhenti
                System.out.println("Sistem berhenti dengan aman."); 
            }
        } catch (InterruptedException e) {
            System.out.println("Terjadi kesalahan saat menutup sistem.");
        }
    }
}
