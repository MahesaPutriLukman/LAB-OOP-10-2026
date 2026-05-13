package soal1;

import java.util.*;

// Class Kurir berjalan sebagai thread (proses yang bisa berjalan sendiri)
class Kurir implements Runnable {

    // menyimpan akses ke Gudang
    private Gudang gudang;

    // untuk menghasilkan angka acak
    private Random random = new Random();

    // constructor: menghubungkan kurir dengan gudang
    public Kurir(Gudang gudang){
        this.gudang = gudang;
    }

    // method utama yang dijalankan oleh thread
    @Override
    public void run(){

        // loop berjalan terus selama thread belum dihentikan
        while (!Thread.currentThread().isInterrupted()){
            try {

                // kurir mengambil barang secara acak (1 sampai 4 barang)
                int jumlah = random.nextInt(4) + 1;

                // kurir mengambil stok dari gudang
                gudang.ambilStok(jumlah);

                // kurir istirahat sebentar (2–3 detik)
                Thread.sleep((random.nextInt(2) + 2) * 1000);

            } catch (InterruptedException e){

                // jika thread dihentikan, keluar dari loop
                System.out.println("Kurir berhenti.");
                break;
            }
        }
    }
}