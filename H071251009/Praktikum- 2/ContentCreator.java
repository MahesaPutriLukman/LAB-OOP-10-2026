class ContentCreator {
    String nama;
    int subscriber;
    kamera kamera; // atribut objek dari class lain

    // construktor default
    ContentCreator() {
        nama = "Tidak diketahuai";
        subscriber = 0;
        kamera = new kamera("Standar", 720);
    }
    // construktor dengan parameter
    ContentCreator(String nama, int subscriber, kamera kamera){
        this.nama = nama;
        this.subscriber = subscriber;
        this.kamera = kamera;
    }

    // Method 1 : upload konten
    void uploadkonten(){
        subscriber +=100;
        System.out.println(nama + " mengupload konten dan mendapatkan 100 subscriber ! ");
    }

    // method 2 : interaksi antar objeck (collab)
    void collab(ContentCreator teman){
        System.out.println(nama + " berkolaborasi dengan " + teman.nama);

        this.subscriber += 50;
        teman.subscriber += 50;

        System.out.println("Subscriber keduanya bertambah");
    }

    // method tambahan
    void tampilkaninfo(){
        System.out.println("Nama Creator : " + nama);
        System.out.println("Subscriber :" + subscriber);
        System.out.println("Kamera : " + kamera.tipe + " (" + kamera.resolusi + "p)");
        System.out.println("-----------------------");
    }
}
