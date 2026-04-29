package Tugas2;
// Kelas Main untuk menguji semua fitur dari SmartLamp, SmartCCTV, dan SmartSpeaker
// Kelas ini menunjukkan bagaimana setiap perangkat elektronik dapat diakses melalui abstract class dan interface yang telah didefinisikan.
// Dalam kelas ini, kita akan membuat objek dari setiap perangkat dan memanggil method yang sesuai untuk menunjukkan fungsionalitasnya.

public class Main {
    public static void main(String[] args) {
        System.out.println("\n-------------------------------------------------");
        System.out.println("========== CYBERGLOW SMART HOME SYSTEM ==========");
        System.out.println("-------------------------------------------------\n");

        // 1. Instansiasi SmartLamp
        SmartLamp lampu = new SmartLamp("Philips Hue", 10);
        System.out.println("[Uji Coba Smart Lamp]");
        lampu.infoPower();
        lampu.cekFungsi();
        lampu.prosesPerintah("NYALA");
        System.out.println();

        // 2. Instansiasi SmartCCTV
        SmartCCTV cctv = new SmartCCTV("Xiaomi Security", 15);
        System.out.println("[Uji Coba Smart CCTV]");
        cctv.infoPower();
        cctv.cekFungsi();
        cctv.hubungkanWiFi();
        System.out.println();

        // 3. Instansiasi SmartSpeaker (Menunjukkan akses ke semua fitur)
        SmartSpeaker speaker = new SmartSpeaker("Google Home", 25);
        System.out.println("[Uji Coba Smart Speaker - Multi Fitur]");
        
        // Akses dari abstract class
        speaker.infoPower();
        speaker.cekFungsi();
        
        // Akses dari interface InteraksiInternet
        speaker.hubungkanWiFi();
        
        // Akses dari interface KontrolSuara
        speaker.prosesPerintah("Putar lagu jazz");

        System.out.println("\n-------------------------------------------------");
        System.out.println("======= PROTOCOL HARMONY BERJALAN LANCAR =======");
        System.out.println("-------------------------------------------------\n");
    }
}
