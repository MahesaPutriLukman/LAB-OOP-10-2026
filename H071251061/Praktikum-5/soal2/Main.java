package soal2;
public class Main {
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp("Philips Hue", 10);
        SmartCCTV cctv = new SmartCCTV("Xiaomi Cam", 5);
        SmartSpeaker speaker = new SmartSpeaker("Google Home", 15);

        lampu.infoPower();
        lampu.prosesPerintah("NYALA");

        cctv.infoPower();
        cctv.hubungkanWiFi();

        System.out.println("\n--- Testing SmartSpeaker ---");
        speaker.infoPower();
        speaker.cekFungsi();
        speaker.hubungkanWiFi();
        speaker.prosesPerintah("Putar Musik");
    }
}