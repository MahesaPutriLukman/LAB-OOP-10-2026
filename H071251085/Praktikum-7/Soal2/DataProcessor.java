import java.util.Random;

class DataProcessor {
    Random random = new Random();

    public int process(String fileName)
            throws InterruptedException {

        int waktu =
                random.nextInt(1501) + 500;

        Thread.sleep(waktu);

        int jumlahKata =
                random.nextInt(500) + 100;

        return jumlahKata;
    }
}