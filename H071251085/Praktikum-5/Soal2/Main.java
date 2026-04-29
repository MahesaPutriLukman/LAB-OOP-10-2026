package Soal2;
public class Main {
    public static void main(String[] args) {

        // Instansiasi objek
        SmartLamp lamp =
                new SmartLamp("Philips", 10);

        SmartCCTV cctv =
                new SmartCCTV("Xiaomi", 25);

        SmartSpeaker speaker =
                new SmartSpeaker("Sony", 15);

        // SmartLamp
        System.out.println("=== SMART LAMP ===");
        System.out.println(lamp.cekFungsi());
        lamp.infoPower();
        lamp.prosesPerintah("NYALA");

        // SmartCCTV
        System.out.println("\n=== SMART CCTV ===");
        System.out.println(cctv.cekFungsi());
        cctv.infoPower();
        cctv.hubungkanWiFi();

        // SmartSpeaker
        System.out.println("\n=== SMART SPEAKER ===");
        System.out.println(speaker.cekFungsi());
        speaker.infoPower();
        speaker.hubungkanWiFi();
        speaker.prosesPerintah("putar musik");
    }
}