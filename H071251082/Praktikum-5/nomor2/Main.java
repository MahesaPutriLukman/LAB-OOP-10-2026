package nomor2;

public class Main {
    public static void main(String[] args) {
        SmartLamp lampu = new SmartLamp("Phillips", 12);
        SmartCCTV cctv = new SmartCCTV("Hikvision", 15);
        SmartSpeaker speaker = new SmartSpeaker("Amazon Echo", 20);

        lampu.infoPower();
        lampu.cekFungsi();
        lampu.prosesPerintah("NYALA");
        lampu.prosesPerintah("MATI");
        System.out.println();
        cctv.infoPower();
        cctv.cekFungsi();
        cctv.hubungkanWiFi();
        System.out.println();
        speaker.infoPower();
        speaker.cekFungsi();
        speaker.hubungkanWiFi();
        speaker.prosesPerintah("Putar Mars Unhas");
    }
}
