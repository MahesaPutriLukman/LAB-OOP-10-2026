import java.util.*;
class Pemasok implements Runnable{
    private Gudang gudang;
    private Random random = new Random();

    public Pemasok(Gudang gudang){
        this.gudang = gudang;
    }

    @Override
    public void run(){
        while (!Thread.currentThread().isInterrupted()){

            try {
                int jumlah = random.nextInt(5)+1;
                gudang.tambahStok(jumlah);

                Thread.sleep((random.nextInt(2)+1)*1000);
            } catch (InterruptedException e) {
                System.out.println("Pemasok berhenti.");
                break;
            }
        }
    }
}
