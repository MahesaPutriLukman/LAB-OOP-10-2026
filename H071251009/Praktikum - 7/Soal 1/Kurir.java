import java.util.*;
class Kurir implements Runnable {
    private Gudang gudang;
    private Random random = new Random();

    public Kurir(Gudang gudang){
        this.gudang = gudang;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){
            try {
                int jumlah = random.nextInt(4)+1;
                gudang.ambilStok(jumlah);

                Thread.sleep((random.nextInt(2)+2)*1000);
            } catch (InterruptedException e){
                System.out.println("Kurir berhenti.");
                break;
            }
        }
    }
}
