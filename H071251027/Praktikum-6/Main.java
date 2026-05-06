import java.util.Scanner;

public class Main {

    // untuk input dari user
    static Scanner sc = new Scanner(System.in);

    // objek perpustakaan (tempat semua data disimpan)
    static perpus library = new perpus();

    public static void main(String[] args) {

        while (true) {
            menu();

            int pilih = inputInt("Pilih menu (1-8): ");

            try {
                switch (pilih) {

                    case 1:
                        tambahItem();
                        break;

                    case 2:
                        tambahMember();
                        break;

                    case 3:
                        pinjamItem();
                        break;

                    case 4:
                        kembalikanItem();
                        break;

                    case 5:
                        System.out.println(library.getLibraryStatus());
                        break;

                    case 6:
                        System.out.println(library.getAllLogs());
                        break;

                    case 7:
                        lihatPinjamanMember();
                        break;

                    case 8:
                        System.out.println("Keluar...");
                        return;

                    default:
                        System.out.println("Menu tidak tersedia!");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // input angka yang aman (kalau salah input, akan minta ulang)
    static int inputInt(String pesan) {
        while (true) {
            System.out.print(pesan);

            if (sc.hasNextInt()) {
                int n = sc.nextInt();
                sc.nextLine(); // buang enter
                return n;
            } else {
                System.out.println("Harus angka!");
                sc.nextLine(); // buang input salah
            }
        }
    }

    // tambah item ke perpustakaan (buku atau DVD)
    static void tambahItem() {
        System.out.println("1. Buku");
        System.out.println("2. DVD");

        int jenis = inputInt("Pilih: ");

        System.out.print("Judul: ");
        String judul = sc.nextLine();

        int id = inputInt("ID: ");

        if (jenis == 1) {
            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.println(library.addItem(new buku(judul, id, author)));

        } else if (jenis == 2) {
            int durasi = inputInt("Durasi: ");

            System.out.println(library.addItem(new DVD(judul, id, durasi)));

        } else {
            System.out.println("Pilihan tidak valid!");
        }
    }

    // tambah member baru
    static void tambahMember() {
        System.out.print("Nama: ");
        String nama = sc.nextLine();

        int id = inputInt("ID: ");

        library.addMember(new member(nama, id));
    }

    // mencari member berdasarkan nama
    static member cariMember(String nama) {
        for (member m : library.Member) {
            if (m.nama.equalsIgnoreCase(nama)) {
                return m;
            }
        }
        return null;
    }

    // proses peminjaman item
    static void pinjamItem() {
        System.out.print("Nama Member: ");
        String nama = sc.nextLine();

        member m = cariMember(nama);

        if (m == null) {
            System.out.println("Member tidak ditemukan!");
            return;
        }

        int id = inputInt("ID Item: ");
        int hari = inputInt("Hari: ");

        try {
            BarangPerpus item = library.findItemById(id);

            String hasil = m.meminjam(item, hari);
            System.out.println(hasil);

            // catat log peminjaman
            library.logger.logPinjamItem(item.judul, nama);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // proses pengembalian item
    static void kembalikanItem() {
        System.out.print("Nama Member: ");
        String nama = sc.nextLine();

        member m = cariMember(nama);

        if (m == null) {
            System.out.println("Member tidak ditemukan!");
            return;
        }

        int id = inputInt("ID Item: ");
        int telat = inputInt("Terlambat (hari): ");

        try {
            BarangPerpus item = library.findItemById(id);

            String hasil = m.mengembalikan(item, telat);
            System.out.println(hasil);

            // catat log pengembalian
            library.logger.logKembalikanItem(item.judul, nama);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // melihat daftar pinjaman milik member
    static void lihatPinjamanMember() {
        System.out.print("Nama Member: ");
        String nama = sc.nextLine();

        member m = cariMember(nama);

        if (m != null) {
            m.tabelDataPinjamanMember();
        } else {
            System.out.println("Member tidak ditemukan!");
        }
    }

    // menu utama program
    static void menu() {
        System.out.println("\n=== Sistem Perpustakaan ===");
        System.out.println("1. Tambah Item");
        System.out.println("2. Tambah Anggota");
        System.out.println("3. Pinjam Item");
        System.out.println("4. Kembalikan Item");
        System.out.println("5. Lihat Status perpustakaan");
        System.out.println("6. Lihat Log Aktivitas");
        System.out.println("7. Lihat Item yang Dipinjam Anggota");
        System.out.println("8. Keluar");
    }
}