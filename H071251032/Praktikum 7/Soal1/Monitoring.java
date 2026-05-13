package Soal1;

class Monitoring implements Runnable {
    private Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                int stok = gudang.getStok(); //atribut stok diambil dari Gudang untuk ditampilkan di monitoring
                int kapasitas = gudang.getKapasitasMaksimal(); 
                
                // Menghitung persentase untuk visualisasi progress bar di monitoring
                int persen = (stok * 100) / kapasitas;
                
                // Membuat visual progress bar [##########----------]
                String bar = ""; // string kosong untuk membangun progress bar berdasarkan persentase stok di gudang
                int jumlahHashtag = persen / 5; // karena progress bar terdiri dari 20 karakter, setiap 5% akan menambah 1 hashtag (#) di progress bar
                
                for (int i = 0; i < 20; i++) { // loop untuk membangun progress bar dengan total 20 karakter
                    if (i < jumlahHashtag) {
                        bar = bar + "#";
                    } else {
                        bar = bar + "-";
                    }
                }

                System.out.println("\nStatus Gudang: [" + bar + "] " + persen + "%");
                
                // Update setiap 1 detik untuk memberikan informasi stok terkini di gudang
                Thread.sleep(1000); // 1000ms = 1 detik
            }
        } catch (InterruptedException e) {
            // Berhenti
        }
    }
}