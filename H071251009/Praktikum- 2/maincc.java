public class maincc {
    public static void main(String[] args) {
        
        // objek kamera
        kamera kamera1 = new kamera("Canon", 1080);
        kamera kamera2 = new kamera("Sony", 144);

        // objek content creator
        ContentCreator creator1 = new ContentCreator("BotakCilla'",1000,kamera1);
        ContentCreator creator2 = new ContentCreator("Baco_siu",800,kamera2);

        // data awal
        creator1.tampilkaninfo();
        creator2.tampilkaninfo();

        // upload konten
        creator1.uploadkonten();

        // kolaborasi
        creator1.collab(creator2);

        // Data akhir
        creator1.tampilkaninfo();
        creator2.tampilkaninfo();
    }
}
