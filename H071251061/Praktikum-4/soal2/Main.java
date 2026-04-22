package soal2;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product[] daftarStok = new Product[100];
        int jumlahProduk = 0;
        int pilihan = 0;

        do {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Tambah Produk");
                System.out.println("2. Tampilkan Semua Produk");
                System.out.println("3. Beli Produk");
                System.out.println("4. Keluar");
                System.out.print("\n>>> Pilih menu (1-4): ");
                
                pilihan = sc.nextInt();
                sc.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan nama produk: ");
                        String nama = sc.nextLine();
                        
                        System.out.print("Masukkan nomor seri (angka): ");
                        int sn = sc.nextInt();
                        
                        System.out.print("Masukkan harga (angka): ");
                        double harga = sc.nextDouble();
                        
                        System.out.println("Pilih tipe produk:\n1. Smartphone\n2. Laptop\n3. Camera");
                        System.out.print("Pilih tipe produk (1-3): ");
                        int tipe = sc.nextInt();

                        if (tipe == 1) {
                            System.out.print("Masukkan ukuran layar: ");
                            double ss = sc.nextDouble();
                            System.out.print("Masukkan kapasitas penyimpanan: ");
                            int cap = sc.nextInt();
                            daftarStok[jumlahProduk] = new Smartphone(nama, sn, harga, ss, cap);
                        } else if (tipe == 2) {
                            System.out.print("Masukkan RAM: ");
                            int ram = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Masukkan tipe prosesor: ");
                            String proc = sc.nextLine();
                            daftarStok[jumlahProduk] = new Laptop(nama, sn, harga, ram, proc);
                        } else if (tipe == 3) {
                            System.out.print("Masukkan resolusi: ");
                            int res = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Masukkan tipe lensa: ");
                            String lens = sc.nextLine();
                            daftarStok[jumlahProduk] = new Camera(nama, sn, harga, res, lens);
                        }
                        
                        jumlahProduk++;
                        System.out.println("Produk berhasil ditambahkan!");
                        break;

                    case 2:
                        System.out.println("\n--- Daftar Produk ---");
                        for (int i = 0; i < jumlahProduk; i++) {
                            if (daftarStok[i] != null) {
                                daftarStok[i].displayInfo();
                                System.out.println("-----------------");
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
                        int searchSn = sc.nextInt();
                        boolean ditemukan = false;
                        
                        for (int i = 0; i < jumlahProduk; i++) {
                            if (daftarStok[i] != null && daftarStok[i].seriesNumber == searchSn) {
                                System.out.println("Anda telah membeli produk:");
                                daftarStok[i].displayInfo();
                                daftarStok[i] = null;
                                ditemukan = true;
                                break;
                            }
                        }
                        
                        if (!ditemukan) {
                            System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
                        }
                        break;

                    case 4:
                        System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                        break;
                    
                    default:
                        System.out.println("Pilihan tidak valid! Masukkan angka 1-4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Kesalahan Input: Harap masukkan angka, bukan huruf/simbol!");
                sc.nextLine();
                pilihan = 0;
            }
        } while (pilihan != 4);
        
        sc.close();
    }
}