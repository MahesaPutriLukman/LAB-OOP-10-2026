public class Petani {
    String namaPetani;
    int jumlahHasilPanen;
    Tanaman tanamanSaatIni;

    public Petani() {
        this.namaPetani = "Jack Programer Pensiun";
        this.jumlahHasilPanen = 0;
        this.tanamanSaatIni = null;
    }

    public Petani(String namaPetani, int jumlahHasilPanen) {
        this.namaPetani = namaPetani;
        this.jumlahHasilPanen = jumlahHasilPanen;
    }

    public void menanam() {
        int acak = (int) (Math.random() * 3);
    
        if (acak == 0) {
            this.tanamanSaatIni = new Tanaman("Padi", 100);
        } else if (acak == 1) {
            this.tanamanSaatIni = new Tanaman("Jagung", 90);
        } else {
            this.tanamanSaatIni = new Tanaman("Kedelai", 85);
        }
        System.out.println(namaPetani + " mulai menanam " + tanamanSaatIni.jenis);
    }

    public void bantuPanen(Petani teman) {
        if (teman.tanamanSaatIni != null) {
            System.out.println(this.namaPetani + " membantu memanen lahan milik " + teman.namaPetani);
            
            this.jumlahHasilPanen += 10;
            teman.jumlahHasilPanen += 50;
            
            teman.tanamanSaatIni = null;
        } else {
            System.out.println("Lahan " + teman.namaPetani + " tidak ada tanaman untuk dipanen.");
        }
    }

    public void cekGudang() {
        System.out.println("--- Laporan Petani ---");
        System.out.println("Nama Petani : " + namaPetani);
        System.out.println("Hasil Panen : " + jumlahHasilPanen + " kg");
        if (tanamanSaatIni != null) {
            System.out.println("Status Lahan: Menanam " + tanamanSaatIni.jenis);
        } else {
            System.out.println("Status Lahan: Kosong");
        }
        System.out.println("----------------------");
    }
}