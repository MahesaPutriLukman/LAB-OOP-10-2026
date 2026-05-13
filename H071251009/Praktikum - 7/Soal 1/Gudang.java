public class Gudang {
    int stok;
    int kapasitasMaksimal;
    Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
    }
    synchronized void tambahStok(int jumlah) throws InterruptedException {
        while(stok + jumlah > kapasitasMaksimal){
            System.out.println("Kapasitas penuh, harap menunggu hingga kapasitas tersedia.");
            wait();
        }
        stok += jumlah;
        System.out.println("Stok barang bertambah: "+ jumlah + " | kapasitas sekarang: "+ stok);
        notifyAll();
    }

    synchronized void ambilStok(int jumlah) throws InterruptedException {
        while(stok < jumlah){
            System.out.println("Stok kosong, mohon menunggu.");
            wait();
        }
        stok -= jumlah;
        System.out.println("stok barang berkurang: "+ jumlah + " | kapasitas sekarang: "+ stok);
        notifyAll();
    }
    
}
