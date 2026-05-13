import java.util.Scanner;

public class Main {

    static Library library = new Library();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Sistem Manajemen Perpustakaan ===");

        boolean running = true;
        while (running) {
            tampilkanMenu();

            int pilihan = bacaAngka("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    tambahItem();
                    break;
                case 2:
                    tambahAnggota();
                    break;
                case 3:
                    pinjamItem();
                    break;
                case 4:
                    kembalikanItem();
                    break;
                case 5:
                    lihatStatusPerpustakaan();
                    break;
                case 6:
                    lihatLogAktivitas();
                    break;
                case 7:
                    lihatItemDipinjamAnggota();
                    break;
                case 8:
                    System.out.println("Terima kasih! Program selesai.");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

            System.out.println();
        }

        scanner.close();
    }

    static void tampilkanMenu() {
        System.out.println("=== Sistem Manajemen Perpustakaan ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status Perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
    }

    static void tambahItem() {
        System.out.println("\n-- Tambah Item --");
        System.out.println("1. Buku");
        System.out.println("2. DVD");
        int tipe = bacaAngka("Pilih tipe item: ");

        int id = bacaAngka("Masukkan ID item: ");
        System.out.print("Masukkan judul: ");
        String judul = scanner.nextLine();

        if (tipe == 1) {
            System.out.print("Masukkan nama penulis: ");
            String penulis = scanner.nextLine();
            Book buku = new Book(judul, id, penulis);
            String hasil = library.addItem(buku);
            System.out.println(hasil);

        } else if (tipe == 2) {
            int durasi = bacaAngka("Masukkan durasi (menit): ");
            DVD dvd = new DVD(judul, id, durasi);
            String hasil = library.addItem(dvd);
            System.out.println(hasil);

        } else {
            System.out.println("Tipe item tidak valid.");
        }
    }

    static void tambahAnggota() {
        System.out.println("\n-- Tambah Anggota --");
        int id = bacaAngka("Masukkan ID anggota: ");
        System.out.print("Masukkan nama anggota: ");
        String nama = scanner.nextLine();

        Member member = new Member(nama, id);
        String hasil = library.addMember(member);
        System.out.println(hasil);
    }

    static void pinjamItem() {
        System.out.println("\n-- Pinjam Item --");
        int memberId = bacaAngka("Masukkan ID anggota: ");
        int itemId = bacaAngka("Masukkan ID item: ");
        int hari = bacaAngka("Masukkan jumlah hari peminjaman: ");

        try {
            String hasil = library.borrowItem(memberId, itemId, hari);
            System.out.println(hasil);
        } catch (Exception e) {
            System.out.println("Gagal meminjam: " + e.getMessage());
        }
    }

    static void kembalikanItem() {
        System.out.println("\n-- Kembalikan Item --");
        int memberId = bacaAngka("Masukkan ID anggota: ");
        int itemId = bacaAngka("Masukkan ID item: ");
        int hariTerlambat = bacaAngka("Masukkan jumlah hari keterlambatan (0 jika tidak terlambat): ");

        try {
            String hasil = library.returnItem(memberId, itemId, hariTerlambat);
            System.out.println(hasil);
        } catch (Exception e) {
            System.out.println("Gagal mengembalikan: " + e.getMessage());
        }
    }

 
    static void lihatStatusPerpustakaan() {
        System.out.println("\n-- Status Perpustakaan --");
        System.out.println(library.getLibraryStatus());
    }

    static void lihatLogAktivitas() {
        System.out.println("\n-- Log Aktivitas --");
        System.out.println(library.getAllLogs());
    }

    static void lihatItemDipinjamAnggota() {
        System.out.println("\n-- Item yang Dipinjam Anggota --");
        int memberId = bacaAngka("Masukkan ID anggota: ");

        try {
            Member member = library.findMemberById(memberId);
            System.out.println("Item yang dipinjam oleh " + member.getName() + ":");
            member.getBorrowedItems();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static int bacaAngka(String pesan) {
        int angka = -1;
        while (true) {
            System.out.print(pesan);
            try {
                angka = Integer.parseInt(scanner.nextLine().trim());
                break; 
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
            }
        }
        return angka;
    }
}
