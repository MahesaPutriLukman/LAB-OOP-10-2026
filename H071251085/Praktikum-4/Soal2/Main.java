package Soal2;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Produk> products = new ArrayList<>();

        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");

            try {
                System.out.print(">>> Pilih menu (1-4): ");
                pilih = input.nextInt();
                
                
            } catch (InputMismatchException e) {
                System.out.println("Error: Masukkan angka, bukan huruf!");
                input.nextLine(); 
                pilih = 0;
            }

            switch (pilih) {
                case 1:
                    tambahProduk(input, products);
                    break;

                case 2:
                    tampilkanProduk(products);
                    break;

                case 3:
                    beliProduk(input, products);
                    break;

                case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    break;

                default:
                    System.out.println("Menu tidak valid!");
            }

        } while (pilih != 4);

        input.close();
    }

    static void tambahProduk(Scanner input, ArrayList<Produk> products) {
        input.nextLine();

        System.out.print("Masukkan nama produk: ");
        String brand = input.nextLine();

        System.out.print("Masukkan nomor seri: ");
        int serial = input.nextInt();

        System.out.print("Masukkan harga: ");
        double price = input.nextDouble();

        System.out.println("Pilih tipe produk:");
        System.out.println("1. Smartphone");
        System.out.println("2. Laptop");
        System.out.println("3. Camera");
        System.out.print("Pilih tipe produk (1-3): ");
        int type = input.nextInt();

        switch (type) {
            case 1:
                System.out.print("Masukkan ukuran layar (inch): ");
                double screen = input.nextDouble();

                System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                int storage = input.nextInt();

                products.add(new Smartphone(brand, serial, price, screen, storage));
                break;

            case 2:
                System.out.print("Masukkan RAM Size (GB): ");
                int ram = input.nextInt();

                input.nextLine();
                System.out.print("Masukkan Processor Type: ");
                String processor = input.nextLine();

                products.add(new Laptop(brand, serial, price, ram, processor));
                break;

            case 3:
                System.out.print("Masukkan resolusi kamera (MP): ");
                int resolution = input.nextInt();

                input.nextLine();
                System.out.print("Masukkan tipe lensa: ");
                String lens = input.nextLine();

                products.add(new Camera(brand, serial, price, resolution, lens));
                break;

            default:
                System.out.println("Tipe produk tidak valid!");
        }
    }

    static void tampilkanProduk(ArrayList <Produk> products) {
        if (products.isEmpty()) {
            System.out.println("Belum ada produk.");
            return;
        }

        System.out.println("\nDaftar Produk:");
        for (Produk p : products) {
            p.displayInfo();
            System.out.println();
        }
    }

    static void beliProduk(Scanner input, ArrayList<Produk> products) {
        System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
        int serial = input.nextInt();

        boolean found = false;

        for (Produk p : products) {
            if (p.serialNumber == serial) {
                System.out.println("Anda telah membeli produk:");
                p.displayInfo();
                products.remove(p);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
        }
    }
}