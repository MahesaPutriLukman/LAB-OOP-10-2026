public class Main {
    public static void main(String[] args) {
        SmartLamp lampu1= new SmartLamp("Philips", 45);
        SmartCCTV cctv1 = new SmartCCTV("HIv", 80);
        SmartSpeaker speaker = new SmartSpeaker("JBLV123", 90);
        // untuk lampu
        System.out.println("Produk: "+ lampu1.merk);
        System.out.println("Daya yang digunakan: "+ lampu1.dayaListrik);
        lampu1.ProsesPerintah("NYALA");
        lampu1.cekFungsi();
        // untuk cctv1
        System.out.println("Produk: "+ cctv1.merk);
        System.out.println("Daya yang digunakan: "+ cctv1.dayaListrik);
        cctv1.hubungkanWIFI();
        cctv1.cekFungsi();
        // untuk speaker
        System.out.println("Produk: "+speaker.merk );
        System.out.println("Daya yang digunakan"+speaker.dayaListrik);
        speaker.ProsesPerintah("NYALA");
        speaker.hubungkanWIFI();
        speaker.cekFungsi();

    }
}
