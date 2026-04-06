package QuidditchCompetition;

public class PemainQuidditch {
    //minimal 3 atribut dan salah satu adalah objek dari class lain
    String nama;
    int stamina;
    SapuTerbang kendaraan; //objek dari class SapuTerbang

    //Class harus memiliki minimal 2 constructor
    //Constructor Default (Tanpa parameter)
    public PemainQuidditch() {
        this.nama = "Pemain Cadangan";
        this.stamina = 50;
        this.kendaraan = new SapuTerbang("Sapu Standar", 30);
    }
    //Constructor dengan parameter 
    public PemainQuidditch(String nama, int stamina, SapuTerbang kendaraan) {
        this.nama = nama;
        this.stamina = stamina;
        this.kendaraan = kendaraan;
    }

    //Minimal 2 Behavior (Method) di luar setter-getter
    //Method 1: Berinteraksi langsung dengan atribut objek (kendaraan)
    public void rawatSapu() {
        System.out.println("\n" + this.nama + " sedang merawat sapunya: " + kendaraan.merek);
        
        // Efek merawat sapu: kecepatan sapu bertambah, namun stamina berkurang
        this.kendaraan.kecepatan += 5;
        this.stamina -= 5; 
        System.out.println("Selesai! Kecepatan sapu " + kendaraan.merek + " sekarang meningkat.");
    }

    //Melibatkan interaksi antar objek dari class yang sama
    // Method ini menerima parameter bertipe class yang sama (PemainQuidditch)
    public void rebutanQuaffle(PemainQuidditch lawan) {
        System.out.println("\n[PERTANDINGAN] " + this.nama + " dan " + lawan.nama + " sedang berebut bola Quaffle di udara!");
        
        //Pemain dengan (Kecepatan Sapu + Stamina) tertinggi yang menang!
        int kekuatanKita = this.kendaraan.kecepatan + this.stamina;
        int kekuatanLawan = lawan.kendaraan.kecepatan + lawan.stamina;
        
        if (kekuatanKita > kekuatanLawan) {
            System.out.println(this.nama + " berhasil menabrak bahu " + lawan.nama + " dan merebut bola Quaffle!");
            
            //stamina lawan terkuras karena benturan
            lawan.stamina -= 20;
            this.stamina -= 10; // penyerang juga lelah
        } else if (kekuatanKita < kekuatanLawan) {
            System.out.println(lawan.nama + " lebih cepat dan mengamankan bola Quaffle!");
            
            // Efek sebaliknya
            this.stamina -= 20;
            lawan.stamina -= 10;
        } else {
            System.out.println(" Kedua pemain saling bertabrakan keras! Bola Quaffle terjatuh bebas.");
            this.stamina -= 15;
            lawan.stamina -= 15;
        }
    }

    // Method tambahan untuk cetak status
    public void cekStatus() {
        System.out.println("=========== Status Pemain ===========");
        System.out.println("Nama Pemain : " + nama);
        if (stamina <= 0) {
            System.out.println("Stamina     : 0 (Terjatuh dari sapu karena kelelahan!)");
        } else {
            System.out.println("Stamina     : " + stamina);
        }
        System.out.print("Peralatan   : ");
        kendaraan.infoSapu();
        System.out.println("=====================================");
    }
}
