class Monitoring implements Runnable {

    private Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    @Override
    public void run() {

        try {

            while (!Thread.currentThread().isInterrupted()) {

                int stok = gudang.getStok();
                int kapasitas = gudang.getKapasitasMaksimal();

                int persen = (stok * 100) / kapasitas;

                int totalBar = 20;

                int barTerisi =
                        (persen * totalBar) / 100;

                StringBuilder bar =
                        new StringBuilder();

                for (int i = 0; i < totalBar; i++) {

                    if (i < barTerisi) {
                        bar.append("#");
                    } else {
                        bar.append("-");
                    }
                }

                System.out.println("Status Gudang: [" + bar + "] " + persen + "%\n");

                Thread.sleep(1000);
            }

        } catch (InterruptedException e) {

            System.out.println("Monitoring dihentikan.");
        }
    }
}