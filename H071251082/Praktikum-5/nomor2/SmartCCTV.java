package nomor2;

class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {
    public SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }
    
    @Override
    public void cekFungsi(){
        System.out.println("Fungsi: Mengawasi dari jarak jauh.");
    }

    @Override
    public void hubungkanWiFi(){
        System.out.println("Mengirim data ke server...");
    }
}
