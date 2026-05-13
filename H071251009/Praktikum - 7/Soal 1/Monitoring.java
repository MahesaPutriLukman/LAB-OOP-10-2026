public class Monitoring extends Thread{
    private Gudang gudang;

    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    public void TampilkanInfo(){
        int stok = gudang.stok;
        int kapasitas = gudang.kapasitasMaksimal;
        int persen = (stok*100)/kapasitas;
        int isi = (stok * 20)/kapasitas;

        System.out.println("Status gudang: " +
                "["+("#".repeat(isi)) + ("-".repeat(20-isi))+"]"
                + persen + "%" );
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try{
                TampilkanInfo();

                Thread.sleep(1000);

            } catch (InterruptedException e){
                System.out.println("Monitoring berhenti.");
                break;
            }
        }
    }

}
