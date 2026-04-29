import java.util.Scanner;

public class Main {

    private static String inputString(Scanner sc, String label) {
        String nilai = "";
        while (nilai.isEmpty()) {
            System.out.print(label);
            nilai = sc.nextLine().trim();
            if (nilai.isEmpty()) {
                System.out.println("[ERROR] Input tidak boleh kosong. Silakan coba lagi.");
            }
        }
        return nilai;
    }

    private static int inputIntPositif(Scanner sc, String label) {
        int nilai = 0;
        while (nilai <= 0) {
            System.out.print(label);
            try {
                nilai = Integer.parseInt(sc.nextLine().trim());
                if (nilai <= 0) {
                    System.out.println("[ERROR] Angka harus lebih dari 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harus berupa angka bulat.");
            }
        }
        return nilai;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ===== SMART LAMP =====
        System.out.println("========================================");
        System.out.println("           INPUT SMART LAMP             ");
        System.out.println("========================================");

        String merkLamp  = inputString(scanner, "Masukkan merk SmartLamp       : ");
        int dayaLamp     = inputIntPositif(scanner, "Masukkan daya listrik (Watt)  : ");
        String perintahLamp = inputString(scanner, "Masukkan perintah (contoh: NYALA) : ");

        System.out.println();
        try {
            SmartLamp lampu = new SmartLamp(merkLamp, dayaLamp);
            System.out.println("----- HASIL SMART LAMP -----");
            lampu.cekFungsi();
            lampu.infoPower();
            lampu.prosesPerintah(perintahLamp);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR dari Kelas] " + e.getMessage());
        }

        System.out.println();

        // ===== SMART CCTV =====
        System.out.println("========================================");
        System.out.println("           INPUT SMART CCTV             ");
        System.out.println("========================================");

        String merkCCTV = inputString(scanner, "Masukkan merk SmartCCTV      : ");
        int dayaCCTV    = inputIntPositif(scanner, "Masukkan daya listrik (Watt) : ");

        System.out.println();
        try {
            SmartCCTV cctv = new SmartCCTV(merkCCTV, dayaCCTV);
            System.out.println("----- HASIL SMART CCTV -----");
            cctv.cekFungsi();
            cctv.infoPower();
            cctv.hubungkanWiFi();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR dari Kelas] " + e.getMessage());
        }

        System.out.println();

        // ===== SMART SPEAKER =====
        System.out.println("========================================");
        System.out.println("          INPUT SMART SPEAKER           ");
        System.out.println("========================================");

        String merkSpeaker  = inputString(scanner, "Masukkan merk SmartSpeaker        : ");
        int dayaSpeaker     = inputIntPositif(scanner, "Masukkan daya listrik (Watt)      : ");
        String perintahSpk  = inputString(scanner, "Masukkan perintah (contoh: NYALA)  : ");

        System.out.println();
        try {
            SmartSpeaker speaker = new SmartSpeaker(merkSpeaker, dayaSpeaker);
            System.out.println("----- HASIL SMART SPEAKER -----");
            // Method dari abstract class
            speaker.cekFungsi();
            speaker.infoPower();
            // Method dari InteraksiInternet
            speaker.hubungkanWiFi();
            // Method dari KontrolSuara
            speaker.prosesPerintah(perintahSpk);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR dari Kelas] " + e.getMessage());
        }

        scanner.close();
    }
}
