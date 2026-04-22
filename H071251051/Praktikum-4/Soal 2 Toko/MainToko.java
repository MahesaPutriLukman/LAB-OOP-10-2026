
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainToko {

    private static List<Product> daftarProduk = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Data produk awal
        daftarProduk.add(new Smartphone("Samsung", 123456, 899.99, 6.5, 256));
        daftarProduk.add(new Laptop("Dell", 987654, 1299.99, 16, "Intel Core i7"));
        daftarProduk.add(new Camera("Canon", 456789, 699.99, 24, "Telephoto"));

        // Loop terus sampai user pilih menu 4
        while (true) {
            tampilkanMenu();
            int pilihan = bacaMenuUtama(sc);

            if (pilihan == 1) {
                tambahProduk(sc);
            } else if (pilihan == 2) {
                tampilkanSemuaProduk();
            } else if (pilihan == 3) {
                beliProduk(sc);
            } else if (pilihan == 4) {
                System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                sc.close();
                return; 
            }
        }
    }

    // Menampilkan menu utama
    private static void tampilkanMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Tampilkan Semua Produk");
        System.out.println("3. Beli Produk");
        System.out.println("4. Keluar");
    }

    // 
    private static int bacaMenuUtama(Scanner sc) {
        while (true) {
            System.out.print("\n>>> Pilih menu (1-4): ");
            try {
                int pilihan = sc.nextInt();
                sc.nextLine(); 

                if (pilihan < 1 || pilihan > 4) {
                    System.out.println("[ERROR] Pilihan tidak valid! Masukkan angka 1-4.");
                } else {
                    return pilihan;
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Input tidak valid! Harap masukkan angka (1-4), bukan huruf atau simbol.");
                sc.nextLine(); 
            }
        }
    }

    // Menu 1: Tambah produk baru
    private static void tambahProduk(Scanner sc) {
        System.out.print("Masukkan nama produk: ");
        String brand = sc.nextLine();

        System.out.print("Masukkan nomor seri: ");
        int seriesNumber = bacaInt(sc, "nomor seri");

        System.out.print("Masukkan harga: ");
        double price = bacaDouble(sc, "harga");

        System.out.println("Pilih tipe produk:");
        System.out.println("1. Smartphone");
        System.out.println("2. Laptop");
        System.out.println("3. Camera");

        int tipe = bacaTipe(sc);

        if (tipe == 1) {
            System.out.print("Masukkan ukuran layar (inci): ");
            double screenSize = bacaDouble(sc, "ukuran layar");
            System.out.print("Masukkan kapasitas penyimpanan (GB): ");
            int storage = bacaInt(sc, "kapasitas penyimpanan");
            daftarProduk.add(new Smartphone(brand, seriesNumber, price, screenSize, storage));
            System.out.println("Smartphone berhasil ditambahkan!");

        } else if (tipe == 2) {
            System.out.print("Masukkan ukuran RAM (GB): ");
            int ram = bacaInt(sc, "ukuran RAM");
            System.out.print("Masukkan tipe prosesor: ");
            String processor = sc.nextLine();
            daftarProduk.add(new Laptop(brand, seriesNumber, price, ram, processor));
            System.out.println("Laptop berhasil ditambahkan!");

        } else if (tipe == 3) {
            System.out.print("Masukkan resolusi (MP): ");
            int resolution = bacaInt(sc, "resolusi");
            System.out.print("Masukkan tipe lensa: ");
            String lens = sc.nextLine();
            daftarProduk.add(new Camera(brand, seriesNumber, price, resolution, lens));
            System.out.println("Kamera berhasil ditambahkan!");
        }
    }

    // Menu 2: Tampilkan semua produk
    private static void tampilkanSemuaProduk() {
        if (daftarProduk.isEmpty()) {
            System.out.println("Belum ada produk di toko.");
            return;
        }

        System.out.println("\nDaftar Produk:");
        for (int i = 0; i < daftarProduk.size(); i++) {
            daftarProduk.get(i).displayInfo();
            System.out.println(); 
        }
    }

    // Menu 3: Beli produk berdasarkan nomor seri
    private static void beliProduk(Scanner sc) {
        System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
        int cariSeri = bacaInt(sc, "nomor seri");

        boolean ditemukan = false;
        for (int i = 0; i < daftarProduk.size(); i++) {
            if (daftarProduk.get(i).getSeriesNumber() == cariSeri) {
                System.out.println("Anda telah membeli produk:");
                daftarProduk.get(i).displayInfo();
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
        }
    }

    // pilihan tipe produk 1-3
    private static int bacaTipe(Scanner sc) {
        while (true) {
            System.out.print("Pilih tipe produk (1-3): ");
            try {
                int tipe = sc.nextInt();
                sc.nextLine();
                if (tipe < 1 || tipe > 3) {
                    System.out.println("[ERROR] Pilih angka 1, 2, atau 3.");
                } else {
                    return tipe;
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Input tidak valid! Masukkan angka 1, 2, atau 3.");
                sc.nextLine();
            }
        }
    }

    private static int bacaInt(Scanner sc, String namaField) {
        while (true) {
            try {
                int nilai = sc.nextInt();
                sc.nextLine();
                return nilai;
            } catch (InputMismatchException e) {
                System.out.print("[ERROR] " + namaField + " harus berupa angka. Coba lagi: ");
                sc.nextLine();
            }
        }
    }

    private static double bacaDouble(Scanner sc, String namaField) {
        while (true) {
            try {
                double nilai = sc.nextDouble();
                sc.nextLine();
                return nilai;
            } catch (InputMismatchException e) {
                System.out.print("[ERROR] " + namaField + " harus berupa angka. Coba lagi: ");
                sc.nextLine();
            }
        }
    }
}