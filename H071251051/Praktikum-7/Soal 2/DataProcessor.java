import java.util.Random;

public class DataProcessor {

    private final Random random = new Random();

    public int process(String fileName) throws InterruptedException {
        int waktuProses = 500 + random.nextInt(2000);
        Thread.sleep(waktuProses);

        return 50 + random.nextInt(451);
    }
}
