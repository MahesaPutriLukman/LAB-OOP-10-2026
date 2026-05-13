public class Monitoring implements Runnable {

    private final Gudang gudang; 

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000); 

                int stok  = gudang.getStok();
                int maks  = gudang.getKapasitasMaksimal();
                int persen = maks > 0 ? (int) ((double) stok / maks * 100) : 0;

                int isi = (int) ((double) stok / maks * 20);
                StringBuilder bar = new StringBuilder("[");
                for (int i = 0; i < 20; i++) {
                    bar.append(i < isi ? "#" : "-");
                }
                bar.append("]");

                System.out.println("\n>>> Status Gudang: " + bar
                        + " " + persen + "% (" + stok + "/" + maks + " barang)\n");

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
            }
        }
        System.out.println("  [Monitoring] Berhenti memantau.");
    }
}
