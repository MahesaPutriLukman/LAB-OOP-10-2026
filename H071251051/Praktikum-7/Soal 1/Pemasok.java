import java.util.Random;

public class Pemasok implements Runnable {

    private final Gudang gudang;  
    private final String nama;    
    private final Random random = new Random();

    public Pemasok(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama   = nama;
    }

    @Override
    public void run() {
        // Pemasok bekerja terus sampai di-interrupt oleh sistem
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // Tambahkan barang secara acak
                int jumlah = random.nextInt(10) + 1;
                gudang.tambahStok(jumlah, nama);

                // Jeda 1-2 detik sebelum menambah lagi
                int jedaMs = 1000 + random.nextInt(1000);
                Thread.sleep(jedaMs);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("  [" + nama + "] Berhenti bekerja.");
    }
}
