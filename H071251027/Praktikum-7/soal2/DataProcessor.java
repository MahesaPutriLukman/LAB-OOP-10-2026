package soal2;
// import class Random untuk membuat angka acak
import java.util.Random;

public class DataProcessor {

    // objek random untuk menghasilkan angka acak
    private Random random = new Random();

    // method process untuk memproses file
    public int process(String fileName) {

        try {

            // membuat waktu acak antara 500 - 2000 milidetik
            int sleepTime = 500 + random.nextInt(1501);

            // menghentikan thread sementara sesuai waktu acak
            Thread.sleep(sleepTime);

        } catch (InterruptedException e) {

            // menangani error jika thread terganggu
            e.printStackTrace();
        }

        // mengembalikan angka acak antara 100 - 999
        return 100 + random.nextInt(900);
    }
}