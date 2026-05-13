package Soal1;
import java.util.Random;

class Kurir implements Runnable { //menggunakan runnable agar bisa dijalankan di thread yang dikelola oleh ExecutorService di Main.java
    private Gudang gudang;
    private Random random = new Random(); //menggunakan Random untuk menghasilkan jumlah barang yang diambil secara acak

    public Kurir(Gudang gudang) { 
        this.gudang = gudang;
    }

    @Override
    // Method run() yang akan dijalankan ketika thread Kurir dijalankan
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) { // Loop terus berjalan sampai thread dihentikan (diinterupsi)
                // Mengambil barang secara acak (misal 1-5 unit)
                int jumlah = random.nextInt(5) + 1;
                gudang.ambilStok(jumlah, Thread.currentThread().getName());
                
                // Menunggu secara acak antara 2-3 detik (2000ms - 3000ms) 
                // karena kurir biasanya membutuhkan waktu untuk mengantarkan barang sebelum kembali ke gudang untuk mengambil lagi
                Thread.sleep(2000 + random.nextInt(1000)); 
            }
        } catch (InterruptedException e) {
            // Berhenti jika thread diinterupsi (ketika sistem dihentikan di Main.java)
        }
    }
}