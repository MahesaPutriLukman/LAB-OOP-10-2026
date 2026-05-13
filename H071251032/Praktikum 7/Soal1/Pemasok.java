package Soal1;
import java.util.Random;

class Pemasok implements Runnable {
    private Gudang gudang;
    private Random random = new Random(); //jumlah barang yang dipasok akan dihasilkan secara acak menggunakan Random

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // Menambah barang secara acak (misal 1-5 unit)
                int jumlah = random.nextInt(5) + 1;
                gudang.tambahStok(jumlah, Thread.currentThread().getName());
                
                // Menunggu secara acak antara 1-2 detik (1000ms - 2000ms) sebelum memasok lagi
                Thread.sleep(1000 + random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            // Berhenti jika thread diinterupsi
        }
    }
}
