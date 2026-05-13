import java.util.Random;

public class Kurir implements Runnable {

    private final Gudang gudang;  
    private final String nama;    
    private final Random random = new Random();

    public Kurir(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama   = nama;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                // Ambil barang secara acak
                int jumlah = random.nextInt(8) + 1;
                gudang.ambilStok(jumlah, nama);

                // Jeda 2-3 detik sebelum mengambil lagi
                int jedaMs = 2000 + random.nextInt(1000); 
                Thread.sleep(jedaMs);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("  [" + nama + "] Berhenti bekerja.");
    }
}
