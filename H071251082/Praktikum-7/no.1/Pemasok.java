import java.util.Random;

class Pemasok implements Runnable {
    Gudang gudang;
    String nama;

    Pemasok(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama = nama;
    }

    @Override
    public void run() {
        Random random = new Random();
        
        try {
            while (true) {
                int jumlahBarang = random.nextInt(5) + 1;
                System.out.println("[" + nama + "] bersiap mengirim " + jumlahBarang + " unit ke gudang.");

                gudang.tambahStok(jumlahBarang);

                int waktuTunggu = 1000 + random.nextInt(1001); 
                Thread.sleep(waktuTunggu);
            }
        } catch (InterruptedException e) {
            System.out.println("[" + nama + "] dihentikan.");
            Thread.currentThread().interrupt();
        }
    }
}