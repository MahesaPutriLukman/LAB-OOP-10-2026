import java.util.Random;

class DataProcessor {
    int process(String fileName) throws InterruptedException {
        Random random = new Random();
        int waktuProses = 500 + random.nextInt(1501); 
        Thread.sleep(waktuProses);
        return 100 + random.nextInt(901);
    }
}