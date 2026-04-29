package Soal1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("===== BANGUN RUANG =====");
        System.out.println("1. Kubus");
        System.out.println("2. Balok");
        System.out.println("3. Bola");
        System.out.println("4. Tabung");

        System.out.println("\n===== BANGUN DATAR =====");
        System.out.println("5. Persegi");
        System.out.println("6. Persegi Panjang");
        System.out.println("7. Lingkaran");
        System.out.println("8. Trapesium");

        System.out.print("Pilihan: ");
        int pilih = input.nextInt();

        switch(pilih){

            case 1:
                System.out.print("Sisi: ");
                Kubus k=new Kubus(input.nextDouble());
                System.out.println("Volume: "+k.volume());
                System.out.println("Luas Permukaan: "+k.luasPermukaan());
                break;

            case 2:
                System.out.print("Panjang: ");
                double p=input.nextDouble();
                System.out.print("Lebar: ");
                double l=input.nextDouble();
                System.out.print("Tinggi: ");
                double t=input.nextDouble();
                Balok b=new Balok(p,l,t);
                System.out.println("Volume: "+b.volume());
                System.out.println("Luas Permukaan: "+b.luasPermukaan());
                break;

            case 3:
                System.out.print("Jari-jari: ");
                Bola bo=new Bola(input.nextDouble());
                System.out.println("Volume: "+bo.volume());
                System.out.println("Luas Permukaan: "+bo.luasPermukaan());
                break;

            case 4:
                System.out.print("Jari-jari: ");
                double r=input.nextDouble();
                System.out.print("Tinggi: ");
                t=input.nextDouble();
                Tabung tb=new Tabung(r,t);
                System.out.println("Volume: "+tb.volume());
                System.out.println("Luas Permukaan: "+tb.luasPermukaan());
                break;

            case 5:
                System.out.print("Sisi: ");
                Persegi ps=new Persegi(input.nextDouble());
                System.out.println("Luas: "+ps.luas());
                System.out.println("Keliling: "+ps.keliling());
                break;

            case 6:
                System.out.print("Panjang: ");
                p=input.nextDouble();
                System.out.print("Lebar: ");
                l=input.nextDouble();
                PersegiPanjang pp=new PersegiPanjang(p,l);
                System.out.println("Luas: "+pp.luas());
                System.out.println("Keliling: "+pp.keliling());
                break;

            case 7:
                System.out.print("Jari-jari: ");
                Lingkaran lg=new Lingkaran(input.nextDouble());
                System.out.println("Luas: "+lg.luas());
                System.out.println("Keliling: "+lg.keliling());
                break;

            case 8:
                System.out.print("Sisi a: ");
                double a=input.nextDouble();
                System.out.print("Sisi b: ");
                double bb=input.nextDouble();
                System.out.print("Sisi c: ");
                double c=input.nextDouble();
                System.out.print("Sisi d: ");
                double d=input.nextDouble();
                System.out.print("Tinggi: ");
                t=input.nextDouble();
                Trapesium tr=new Trapesium(a,bb,c,d,t);
                System.out.println("Luas: "+tr.luas());
                System.out.println("Keliling: "+tr.keliling());
                break;
        }

        input.close();
    }
}