public class Gudang {

    private int stok;                    
    private final int kapasitasMaksimal; 

    public Gudang(int kapasitasMaksimal, int stokAwal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
        this.stok = stokAwal;
        System.out.println("[Gudang] Dibuat dengan kapasitas " + kapasitasMaksimal
                + " dan stok awal " + stokAwal);
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }

    public synchronized void tambahStok(int jumlah, String namaPemasok)
        throws InterruptedException {

        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println("  [" + namaPemasok + "] Gudang PENUH ("
                    + stok + "/" + kapasitasMaksimal
                    + "). Menunggu ada ruang...");
            wait(); 
        }

        stok += jumlah;
        System.out.println("  [" + namaPemasok + "] MENAMBAH " + jumlah
                + " barang. Stok sekarang: " + stok + "/" + kapasitasMaksimal);

        notifyAll();
    }

    public synchronized void ambilStok(int jumlah, String namaKurir)
            throws InterruptedException {

        while (stok < jumlah) {
            System.out.println("  [" + namaKurir + "] Stok KURANG ("
                    + stok + " tersedia, butuh " + jumlah
                    + "). Menunggu stok masuk...");
            wait();
        }

        stok -= jumlah;
        System.out.println("  [" + namaKurir + "] MENGAMBIL " + jumlah
                + " barang. Stok sekarang: " + stok + "/" + kapasitasMaksimal);

        notifyAll(); 
    }
}
