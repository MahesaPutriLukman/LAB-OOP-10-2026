class Monitoring implements Runnable {
    Gudang gudang;

    Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int stokSaatIni = gudang.stok; 
                int kapasitas = gudang.kapasitasMaksimal;

                int persen = (int) (((double) stokSaatIni / kapasitas) * 100);

                int jumlahPagar = persen / 5;
                StringBuilder statusBar = new StringBuilder();
                
                for (int i = 0; i < 20; i++) {
                    if (i < jumlahPagar) {
                        statusBar.append("#");
                    } else {
                        statusBar.append("-");
                    }
                }

                System.out.println("Status Gudang: [" + statusBar.toString() + "] " + persen + "%");

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread Monitoring dihentikan.");
            Thread.currentThread().interrupt();
        }
    }
}