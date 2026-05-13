class Gudang {
    int stok;
    int kapasitasMaksimal;

    Gudang(int kapasitasMaksimal) {
        this.stok = 0; 
        this.kapasitasMaksimal = kapasitasMaksimal;
    }

    synchronized void tambahStok(int jumlah) {
        try {
            while (stok + jumlah > kapasitasMaksimal) {
                System.out.println("Pemasok menunggu... Gudang tidak muat untuk menambah " + jumlah + " unit. (Stok saat ini: " + stok + "/" + kapasitasMaksimal + ")");
                wait(); 
            }

            stok += jumlah;
            System.out.println("Pemasok berhasil menambah " + jumlah + " unit. (Stok saat ini: " + stok + "/" + kapasitasMaksimal + ")");

            notifyAll();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread pemasok dihentikan.");
        }
    }

    synchronized void ambilStok(int jumlah) {
        try {
            while (stok < jumlah) {
                System.out.println("Kurir menunggu... Stok tidak mencukupi untuk mengambil " + jumlah + " unit. (Stok saat ini: " + stok + "/" + kapasitasMaksimal + ")");
                wait(); 
            }

            stok -= jumlah;
            System.out.println("Kurir berhasil mengambil " + jumlah + " unit. (Sisa stok: " + stok + "/" + kapasitasMaksimal + ")");

            notifyAll();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread kurir dihentikan.");
        }
    }
}