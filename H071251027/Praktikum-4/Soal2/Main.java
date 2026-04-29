package Soal2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        ArrayList<Product> list = new ArrayList<>();

        int menu;

        do{
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Semua Produk");
            System.out.println("3. Beli Produk");
            System.out.println("4. Keluar");

            System.out.print("Pilih menu: ");
            menu = input.nextInt();

            if(menu==1){

                input.nextLine();

                System.out.print("Nama produk: ");
                String brand = input.nextLine();

                System.out.print("Nomor seri: ");
                int seri = input.nextInt();

                System.out.print("Harga: ");
                double harga = input.nextDouble();

                System.out.println("1. Smartphone");
                System.out.println("2. Laptop");
                System.out.println("3. Camera");

                System.out.print("Pilih tipe: ");
                int tipe = input.nextInt();

                if(tipe==1){
                    System.out.print("Ukuran layar: ");
                    double layar=input.nextDouble();

                    System.out.print("Storage: ");
                    int storage=input.nextInt();

                    list.add(new Smartphone(brand,seri,harga,layar,storage));
                }
                else if(tipe==2){
                    System.out.print("RAM: ");
                    int ram=input.nextInt();
                    input.nextLine();

                    System.out.print("Processor: ");
                    String proc=input.nextLine();

                    list.add(new Laptop(brand,seri,harga,ram,proc));
                }
                else if(tipe==3){
                    input.nextLine();

                    System.out.print("Resolution: ");
                    String res=input.nextLine();

                    System.out.print("Lens: ");
                    String lens=input.nextLine();

                    list.add(new Camera(brand,seri,harga,res,lens));
                }
            }

            else if(menu==2){

                for(Product p : list){
                    p.displayInfo();
                }
            }

            else if(menu==3){

                System.out.print("Masukkan nomor seri: ");
                int cari=input.nextInt();

                boolean ketemu=false;

                for(int i=0;i<list.size();i++){
                    if(list.get(i).seriesNumber==cari){
                        System.out.println("Produk dibeli:");
                        list.get(i).displayInfo();
                        list.remove(i);
                        ketemu=true;
                        break;
                    }
                }

                if(!ketemu){
                    System.out.println("Produk tidak ditemukan.");
                }
            }

        }while(menu!=4);

        System.out.println("Terima kasih!");
    }
}