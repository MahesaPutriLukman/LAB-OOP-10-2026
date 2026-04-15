import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DompetDigital dompet = new DompetDigital("FF-001", "Scarlet", "123456");

        System.out.println("==============================================");
        System.out.println("          SELAMAT DATANG DI E-WALLET");
        System.out.println("==============================================");

        while (true) {
            tampilkanMenu();

            System.out.print("Pilih menu (1-6): ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    dompet.tampilkanInfo();
                    break;

                case 2:
                    System.out.print("Masukkan PIN lama          : ");
                    String pinLama = scanner.nextLine();
                    System.out.print("Masukkan PIN baru (6 digit): ");
                    String pinBaru = scanner.nextLine();
                    dompet.ubahPin(pinLama, pinBaru);
                    break;

                case 3:
                    System.out.print("Masukkan jumlah setor (Rp): ");
                    double jumlahSetor = scanner.nextDouble();
                    scanner.nextLine();
                    dompet.setorTunai(jumlahSetor);
                    break;

                case 4:
                    System.out.print("Masukkan jumlah tarik (Rp): ");
                    double jumlahTarik = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Masukkan PIN Anda          : ");
                    String pinTarik = scanner.nextLine();
                    dompet.tarikTunai(jumlahTarik, pinTarik);
                    break;

                case 5:
                    System.out.println("Saldo saat ini: Rp " +
                    String.format("%,.0f", dompet.getSaldo()));
                    break;

                case 6:
                    System.out.println("Terima kasih! Sampai jumpa!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

            System.out.println("\nTekan ENTER untuk kembali ke menu...");
            scanner.nextLine();
        }
    }

    static void tampilkanMenu() {
        System.out.println("\n----------- MENU E-WALLET -----------");
        System.out.println("1. Lihat Informasi Akun");
        System.out.println("2. Ubah PIN");
        System.out.println("3. Setor Tunai");
        System.out.println("4. Tarik Tunai");
        System.out.println("5. Cek Saldo");
        System.out.println("6. Keluar");
        System.out.println("-------------------------------------");
    }
}

