import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainGudang {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("   SISTEM LOGISTIK - THE CENTRAL WAREHOUSE");
        System.out.println("==============================================");

        System.out.print("Masukkan kapasitas maksimal gudang       : ");
        int kapasitasMaksimal = scanner.nextInt();

        System.out.print("Masukkan stok awal (0 - " + kapasitasMaksimal + ")           : ");
        int stokAwal = scanner.nextInt();
        stokAwal = Math.max(0, Math.min(stokAwal, kapasitasMaksimal)); 

        System.out.print("Masukkan durasi simulasi dalam detik     : ");
        int durasiDetik = scanner.nextInt();

        System.out.println("\nSimulasi akan berjalan selama " + durasiDetik + " detik.");
        System.out.println("----------------------------------------------\n");

        Gudang gudang = new Gudang(kapasitasMaksimal, stokAwal);
        ExecutorService poolPemasok = Executors.newFixedThreadPool(2);
        ExecutorService poolKurir   = Executors.newFixedThreadPool(3);

        Thread threadMonitoring = new Thread(new Monitoring(gudang), "Monitor");

        poolPemasok.submit(new Pemasok(gudang, "Pemasok-1"));
        poolPemasok.submit(new Pemasok(gudang, "Pemasok-2"));

        poolKurir.submit(new Kurir(gudang, "Kurir-1"));
        poolKurir.submit(new Kurir(gudang, "Kurir-2"));
        poolKurir.submit(new Kurir(gudang, "Kurir-3"));

        threadMonitoring.start();

        Thread.sleep(durasiDetik * 1000L);

        System.out.println("\n[SISTEM] Durasi habis. Menghentikan semua thread...");

        poolPemasok.shutdownNow(); 
        poolKurir.shutdownNow();   
        threadMonitoring.interrupt();

        poolPemasok.awaitTermination(5, TimeUnit.SECONDS);
        poolKurir.awaitTermination(5, TimeUnit.SECONDS);
        threadMonitoring.join(5000);

        System.out.println("\n[SISTEM] Semua thread telah dihentikan.");
        System.out.println("Stok akhir gudang : " + gudang.getStok() + "/" + kapasitasMaksimal + " barang");
        System.out.println("==============================================");

        scanner.close();
    }
}
