package Soal2;

public class MainSoal2 {
    public static void main(String[] args) {

        SmartLamp lamp = new SmartLamp("Philips", 10);
        SmartCCTV cctv = new SmartCCTV("Xiaomi", 20);
        SmartSpeaker speaker = new SmartSpeaker("Google", 30);

        lamp.cekFungsi();
        lamp.prosesPerintah("NYALA");

        cctv.cekFungsi();
        cctv.hubungkanWiFi();

        speaker.cekFungsi();
        speaker.infoPower();
        speaker.hubungkanWiFi();
        speaker.prosesPerintah("Putar Musik");
    }
}