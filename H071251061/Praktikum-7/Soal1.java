import java.util.concurrent.*;
import java.util.Random;

class Gudang {
    private int stok = 0;
    private final int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    public synchronized void tambahStok(int jumlah, String threadName) throws InterruptedException {
        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println(threadName + " menunggu (Gudang Penuh)...");
            wait();
        }
        stok += jumlah;
        System.out.println(threadName + " menambahkan " + jumlah + " barang. Stok saat ini: " + stok);
        notifyAll();
    }

    public synchronized void ambilStok(int jumlah, String threadName) throws InterruptedException {
        while (stok < jumlah) {
            System.out.println(threadName + " menunggu (Stok Kosong)...");
            wait();
        }
        stok -= jumlah;
        System.out.println(threadName + " mengambil " + jumlah + " barang. Stok saat ini: " + stok);
        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}

class Pemasok implements Runnable {
    private final Gudang gudang;
    private final Random random = new Random();

    public Pemasok(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int jumlah = random.nextInt(5) + 1;
                gudang.tambahStok(jumlah, Thread.currentThread().getName());
                Thread.sleep(1000 + random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Kurir implements Runnable {
    private final Gudang gudang;
    private final Random random = new Random();

    public Kurir(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int jumlah = random.nextInt(3) + 1;
                gudang.ambilStok(jumlah, Thread.currentThread().getName());
                Thread.sleep(2000 + random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Soal1 {
    public static void main(String[] args) {
        Gudang gudang = new Gudang(20);
        ExecutorService executor = Executors.newFixedThreadPool(5);

        Thread monitoringThread = new Thread(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    int stok = gudang.getStok();
                    int kapasitas = gudang.getKapasitasMaksimal();
                    int persen = (stok * 100) / kapasitas;
                    int visual = stok * 10 / kapasitas;

                    System.out.print("\nStatus Gudang: [");
                    for (int i = 0; i < 10; i++) {
                        System.out.print(i < visual ? "#" : "-");
                    }
                    System.out.println("] " + persen + "%\n");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        monitoringThread.start();

        for (int i = 0; i < 2; i++) executor.execute(new Pemasok(gudang));
        for (int i = 0; i < 3; i++) executor.execute(new Kurir(gudang));

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sistem dimatikan...");
        executor.shutdownNow();
        monitoringThread.interrupt();
        
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Beberapa thread tidak berhenti tepat waktu.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}