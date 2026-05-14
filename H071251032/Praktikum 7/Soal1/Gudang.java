package Soal1;

class Gudang {
    private int stok;
    private int kapasitasMaksimal;

    public Gudang(int kapasitasMaksimal) {
        this.stok = 0; // Stok awal kosong
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    // Method untuk menambah stok (digunakan Pemasok)
    public synchronized void tambahStok(int jumlah, String namaThread) {
        // Jika stok akan melebihi kapasitas, Pemasok harus menunggu
        while (stok + jumlah > kapasitasMaksimal) {
            try {
                System.out.println("[WAIT] " + namaThread + " menunggu, gudang hampir penuh...");
                wait(); // Pemasok tidur sementara
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Menambah stok jika kapasitas mencukupi
        stok = stok + jumlah;
        System.out.println(namaThread + " memasok " + jumlah + " unit. Stok sekarang: " + stok);
        
        // Memberitahu thread lain (Kurir) bahwa stok bertambah
        notifyAll();
    }

    // Method untuk mengambil stok (digunakan Kurir)
    public synchronized void ambilStok(int jumlah, String namaThread) {
        // Jika stok tidak cukup, Kurir harus menunggu
        while (stok < jumlah) {
            try {
                System.out.println("[WAIT] " + namaThread + " menunggu, stok kosong...");
                wait(); // Kurir tidur sementara
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Mengurangi stok
        stok = stok - jumlah;
        System.out.println(namaThread + " mengambil " + jumlah + " unit. Stok sekarang: " + stok);
        
        // Memberitahu thread lain (Pemasok) bahwa ada ruang kosong di gudang
        notifyAll();
    }

    // Getter untuk monitoring
    public int getStok() {
        return stok;
    }

    public int getKapasitasMaksimal() {
        return kapasitasMaksimal;
    }
}