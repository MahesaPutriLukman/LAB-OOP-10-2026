package nomor2;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
       Product[] daftarProduk = new Product[100];
       int jumlahProduk = 0;

        while(true){
            try {
                System.out.println("Menu:");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Tampilkan Semua Produk");
        System.out.println("3. Beli Produk");
        System.out.println("4. Keluar");
        System.out.print(">>> Pilih menu (1-4): ");

                 int pilihan = x.nextInt();
                x.nextLine();

                switch(pilihan){
                    case 1:
                    if(jumlahProduk == 100){
                        System.out.println("Stok penuh.");
                        System.out.println();
                        break;
                    }
                    System.out.print("Masukkan nama produk: ");
                    String brand = x.nextLine();
                    System.out.print("Masukkan nomor seri: ");
                    int seriesNumber = x.nextInt();
                    x.nextLine();
                    boolean isTerpakai = false;
                    for(int i = 0; i<jumlahProduk; i++){
                        if(daftarProduk[i].seriesNumber == seriesNumber){
                            isTerpakai = true;
                            break;
                        }
                    }

                    if(isTerpakai){
                        System.out.println("Nomor seri telah digunakan.");
                        System.out.println();
                        break;
                    }
                    System.out.print("Masukkan harga: ");
                    double price = x.nextDouble();

                    if(price < 0 ){
                        System.out.println("Harga tidak valid");
                        break;
                    }

                    System.out.println("Pilih tipe produk:");
                    System.out.println("1. Smartphone");
                    System.out.println("2. Laptop");
                    System.out.println("3. Camera");
                    System.out.print("Pilih tipe produk (1-3): ");
                    int tipe = x.nextInt();
                    x.nextLine();

                    if(tipe == 1){
                        System.out.print("Masukkan ukuran layar (inci): ");
                        double screenSize = x.nextDouble();
                        System.out.print("Masukkan kapasitas penyimpanan (GB): ");
                        int storageCapacity = x.nextInt();
                        x.nextLine();
                        daftarProduk[jumlahProduk] = new Smartphone(brand, seriesNumber, price, screenSize, storageCapacity);                                          
                    }else if(tipe == 2){
                        System.out.print("Masukkan Tipe Prosesor: ");
                        String ProcessorType = x.nextLine();
                        System.out.print("Masukkan ukuran RAM (GB): ");
                        int ramSize = x.nextInt();
                        x.nextLine();
                        daftarProduk[jumlahProduk] = new Laptop(brand, seriesNumber, price, ramSize, ProcessorType);
                    }else if(tipe == 3){
                        System.out.print("Masukkan resolusi: ");
                        int resolution = x.nextInt();
                        x.nextLine();
                        System.out.print("Masukkan tipe lensa: ");
                        String lensType = x.nextLine();
                        daftarProduk[jumlahProduk] = new  Camera(brand, seriesNumber, price, resolution, lensType);
                    }else{
                        System.out.println("Tipe produk tidak valid");
                        break;
                    }
                    jumlahProduk++;
                    break;

                    case 2:
                    if(jumlahProduk == 0){
                        System.out.println("Tidak ada produk.");
                    }else{
                        System.out.println("Daftar Produk:");
                        for(int i = 0 ; i < jumlahProduk; i++){
                            daftarProduk[i].displayInfo();
                            System.out.println();
                        }
                    }
                    break;

                    case 3:
                    if(jumlahProduk == 0){
                        System.out.println("Tidak ada produk.");
                        break;
                    }

                    System.out.print("Masukkan nomor seri produk yang ingin dibeli: ");
                    int cariSeri = x.nextInt();
                    x.nextLine();

                    boolean ditemukan = false;
                    for(int i = 0; i < jumlahProduk ;i++){
                        if(daftarProduk[i].seriesNumber == cariSeri){
                            System.out.println("Anda telah membeli produk:");
                            daftarProduk[i].displayInfo();
                            System.out.println();
                            
                            for(int j = i; j <jumlahProduk -1;j++){
                                daftarProduk[j] = daftarProduk[j+1];
                            }
                            jumlahProduk --;
                            ditemukan = true;
                            break;
                        }
                    }
                    if(!ditemukan){
                        System.out.println("Produk dengan nomor seri tersebut tidak ditemukan.");
                    }
                    break;

                    case 4:
                    System.out.println("Terima kasih telah menggunakan layanan kami. Sampai jumpa!");
                    return;

                    default:
                    System.out.println("Input tidak valid.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("ERROR: Input tidak valid. Silahkan masukkan angka yang benar");
                x.nextLine();
            }
        }
    }
}