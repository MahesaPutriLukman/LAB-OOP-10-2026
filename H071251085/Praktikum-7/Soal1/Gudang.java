class Gudang {

    private int stok;
    private int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.kapasitasMaksimal = kapasitasMaksimal;
        this.stok = 0;
    }

    public synchronized void tambahStok(int jumlah, String namaPemasok)
            throws InterruptedException {

        while (stok + jumlah > kapasitasMaksimal) {
            System.out.println(namaPemasok + " menunggu, gudang penuh.");
            wait();
        }

        stok += jumlah;

        System.out.println(namaPemasok + " menambahkan " + jumlah + " barang | Stok sekarang: " + stok);
        notifyAll();
    }

    public synchronized void ambilStok(int jumlah, String namaKurir)
            throws InterruptedException {

        while (stok < jumlah) {
            System.out.println(namaKurir + " menunggu, stok kosong.");
            wait();
        }

        stok -= jumlah;

        System.out.println(namaKurir +
                " mengambil " + jumlah +
                " barang | Stok sekarang: " + stok);

        notifyAll();
    }

    public synchronized int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}