package Tugas2;

import java.util.ArrayList;
import java.util.Scanner;

public class TokoElektronik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> daftarStok = new ArrayList<>();
        
        while (true) {
            System.out.println("\n=======================================");
            System.out.println("       SISTEM TOKO ELEKTRONIK ANDI      ");
            System.out.println("=======================================");
            System.out.println(" 1. Tambah Produk");
            System.out.println(" 2. Tampilkan Semua Produk");
            System.out.println(" 3. Beli Produk (Cek Seri)");
            System.out.println(" 4. Keluar");
            System.out.println("---------------------------------------");
            System.out.print(">>> Pilih Menu (1-4): ");

            String inputMenu = sc.nextLine();
            int pilihan;

            try {
                pilihan = Integer.parseInt(inputMenu);
            } catch (NumberFormatException e) {
                System.out.println("[!] Error: Masukkan angka 1 sampai 4!");
                continue;
            }

            if (pilihan == 4) {
                System.out.println("Terima kasih telah menggunakan sistem Toko Andi!");
                break;
            }

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- TAMBAH PRODUK BARU ---");
                    System.out.print("Masukkan Merek: "); 
                    String brand = sc.nextLine();
                    
                    int seri = 0;
                    while(true) {
                        try {
                            System.out.print("Masukkan No. Seri: ");
                            seri = Integer.parseInt(sc.nextLine());
                            break;
                        } catch (Exception e) { System.out.println("[!] No Seri harus angka!"); }
                    }

                    double harga = 0;
                    while(true) {
                        try {
                            System.out.print("Masukkan Harga: ");
                            harga = Double.parseDouble(sc.nextLine());
                            break;
                        } catch (Exception e) { System.out.println("[!] Harga harus angka!"); }
                    }
                    
                    int tipe = 0;
                    while (true) {
                        System.out.println("\nPilih Tipe Produk:");
                        System.out.println("1. Smartphone | 2. Laptop | 3. Camera");
                        System.out.print("Pilihan (1-3): ");
                        try {
                            tipe = Integer.parseInt(sc.nextLine());
                            if (tipe >= 1 && tipe <= 3) break;
                            else System.out.println("[!] Masukkan angka 1, 2, atau 3.");
                        } catch (Exception e) { System.out.println("[!] Masukkan angka!"); }
                    }

                    try {
                        if (tipe == 1) {
                            System.out.print("Ukuran Layar (inci): "); double layar = Double.parseDouble(sc.nextLine());
                            System.out.print("Penyimpanan (GB): "); int gb = Integer.parseInt(sc.nextLine());
                            daftarStok.add(new Smartphone(brand, seri, harga, layar, gb));
                        } else if (tipe == 2) {
                            System.out.print("RAM (GB): "); int ram = Integer.parseInt(sc.nextLine());
                            System.out.print("Processor: "); String cpu = sc.nextLine();
                            daftarStok.add(new Laptop(brand, seri, harga, ram, cpu));
                        } else if (tipe == 3) {
                            System.out.print("Resolusi (MP): "); int res = Integer.parseInt(sc.nextLine());
                            System.out.print("Tipe Lensa: "); String lensa = sc.nextLine();
                            daftarStok.add(new Camera(brand, seri, harga, res, lensa));
                        }
                        System.out.println("[V] Produk Berhasil Ditambahkan!");
                    } catch (Exception e) {
                        System.out.println("[!] Gagal menambah produk: Input detail salah.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- DAFTAR STOK TOKO ---");
                    if (daftarStok.isEmpty()) {
                        System.out.println("(Stok Kosong)");
                    } else {
                        for (Product p : daftarStok) {
                            p.displayInfo();
                        }
                    }
                    break;

                case 3:
                    try {
                        System.out.print("\nMasukkan No. Seri yang ingin dibeli: ");
                        int cariSeri = Integer.parseInt(sc.nextLine());
                        boolean ditemukan = false;
                        for (int i = 0; i < daftarStok.size(); i++) {
                            if (daftarStok.get(i).seriesNumber == cariSeri) {
                                System.out.println("[OK] Produk Ditemukan!");
                                daftarStok.get(i).displayInfo();
                                System.out.println("Konfirmasi: Pembelian Berhasil. Barang dikeluarkan dari stok.");
                                daftarStok.remove(i);
                                ditemukan = true;
                                break;
                            }
                        }
                        if (!ditemukan) System.out.println("[!] Maaf, No. Seri tidak ditemukan.");
                    } catch (Exception e) { System.out.println("[!] Input No Seri tidak valid!"); }
                    break;

                default:
                    System.out.println("[!] Pilihan menu 1-4 saja.");
            }
        }
        sc.close();
    }
}