import java.util.Random;

class Pemasok implements Runnable {

    private Gudang gudang;
    private String nama;
    private Random random = new Random();

    public Pemasok(Gudang gudang, String nama) {
        this.gudang = gudang;
        this.nama = nama;
    }

    @Override
    public void run() {

        try {

            while (!Thread.currentThread().isInterrupted()) {

                int jumlah = random.nextInt(5) + 1;

                gudang.tambahStok(jumlah, nama);

                Thread.sleep((random.nextInt(2) + 1) * 1000);
            }

        } catch (InterruptedException e) {
            System.out.println(nama + " dihentikan.");
        }
    }
}