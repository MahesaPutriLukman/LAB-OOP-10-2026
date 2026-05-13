package soal1;

import java.util.*;

// Class Pemasok berjalan sebagai thread untuk menambah stok gudang
class Pemasok implements Runnable {

    // akses ke objek Gudang
    private Gudang gudang;

    // untuk menghasilkan angka acak
    private Random random = new Random();

    // constructor untuk menghubungkan pemasok dengan gudang
    public Pemasok(Gudang gudang){
        this.gudang = gudang;
    }

    // method utama yang dijalankan oleh thread
    @Override
    public void run(){

        // loop berjalan terus selama thread belum dihentikan
        while (!Thread.currentThread().isInterrupted()){

            try {

                // menghasilkan jumlah barang acak (1 sampai 5)
                int jumlah = random.nextInt(5) + 1;

                // menambah stok ke gudang
                gudang.tambahStok(jumlah);

                // pemasok istirahat sebentar (1–2 detik)
                Thread.sleep((random.nextInt(2) + 1) * 1000);

            } catch (InterruptedException e) {

                // jika thread dihentikan
                System.out.println("Pemasok berhenti.");
                break;
            }
        }
    }
}