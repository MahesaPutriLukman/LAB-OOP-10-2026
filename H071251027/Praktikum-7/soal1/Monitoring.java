package soal1;

public class Monitoring extends Thread {

    // menyimpan akses ke objek Gudang
    private Gudang gudang;

    // constructor untuk menghubungkan monitoring dengan gudang
    public Monitoring(Gudang gudang) {
        this.gudang = gudang;
    }

    // method untuk menampilkan kondisi stok gudang
    public void TampilkanInfo(){

        // mengambil nilai stok dan kapasitas dari gudang
        int stok = gudang.stok;
        int kapasitas = gudang.kapasitasMaksimal;

        // menghitung persentase stok
        int persen = (stok * 100) / kapasitas;

        // membuat tampilan bar (maksimal 20 kotak)
        int isi = (stok * 20) / kapasitas;

        System.out.println("Status gudang: " +
                "[" + "#".repeat(isi) + "-".repeat(20 - isi) + "]"
                + persen + "%");
    }

    // method utama yang dijalankan oleh thread
    @Override
    public void run(){

        // loop berjalan terus sampai thread dihentikan
        while (!Thread.currentThread().isInterrupted()){
            try {

                // menampilkan kondisi gudang
                TampilkanInfo();

                // jeda 1 detik sebelum update lagi
                Thread.sleep(1000);

            } catch (InterruptedException e){

                // jika thread dihentikan
                System.out.println("Monitoring berhenti.");
                break;
            }
        }
    }
}