package soal1;

// Class Gudang untuk mengatur stok barang
public class Gudang {

    // jumlah stok barang saat ini
    int stok;

    // batas maksimal kapasitas gudang
    int kapasitasMaksimal;

    // constructor untuk menentukan kapasitas gudang
    Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    // method untuk menambah stok barang
    synchronized void tambahStok(int jumlah) throws InterruptedException {

        // kalau stok melebihi kapasitas, thread harus menunggu
        while(stok + jumlah > kapasitasMaksimal){
            System.out.println("Kapasitas penuh, harap menunggu hingga kapasitas tersedia.");
            wait(); // berhenti sementara sampai ada ruang kosong
        }

        // menambah stok barang
        stok += jumlah;

        System.out.println("Stok barang bertambah: " + jumlah +
                " | kapasitas sekarang: " + stok);

        // memberitahu thread lain bahwa ada perubahan stok
        notifyAll();
    }

    // method untuk mengambil stok barang
    synchronized void ambilStok(int jumlah) throws InterruptedException {

        // kalau stok tidak cukup, harus menunggu
        while(stok < jumlah){
            System.out.println("Stok kosong, mohon menunggu.");
            wait(); // berhenti sementara sampai stok tersedia
        }

        // mengurangi stok barang
        stok -= jumlah;

        System.out.println("stok barang berkurang: " + jumlah +
                " | kapasitas sekarang: " + stok);

        // memberitahu thread lain bahwa stok berubah
        notifyAll();
    }
}