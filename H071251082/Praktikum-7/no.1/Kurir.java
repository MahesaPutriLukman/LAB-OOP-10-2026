import java.util.Random;

class Kurir implements Runnable {
    Gudang gudang;
    String nama;

    Kurir(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama = nama;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int jumlahAmbil = random.nextInt(5) + 1;
                System.out.println("[" + nama + "] bersiap mengambil " + jumlahAmbil + " unit dari gudang.");
                
                gudang.ambilStok(jumlahAmbil);

                int waktuTunggu = 2000 + random.nextInt(1001); 
                Thread.sleep(waktuTunggu);
            }
        } catch (InterruptedException e) {
            System.out.println("[" + nama + "] dihentikan.");
            Thread.currentThread().interrupt();
        }
    }
}