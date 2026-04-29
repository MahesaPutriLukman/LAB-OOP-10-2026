import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n---------------------------------------");
            System.out.println("===== BANGUN RUANG =====");
            System.out.println("1. KUBUS\n2. BALOK\n3. BOLA\n4. TABUNG");
            System.out.println("\n===== BANGUN DATAR =====");
            System.out.println("5. PERSEGI\n6. PERSEGI PANJANG\n7. LINGKARAN\n8. TRAPESIUM");
            System.out.println("---------------------------------------");
            System.out.println("0. KELUAR");
            System.out.println("---------------------------------------");

            try {
                System.out.print("Pilihan: ");
                int pil = Integer.parseInt(sc.nextLine());
                if (pil == 0) break;

                switch (pil) {
                    case 1 -> {
                        System.out.print("Sisi: "); double s = Double.parseDouble(sc.nextLine());
                        Kubus obj = new Kubus(s);
                        System.out.println("---------------------------------------");
                        System.out.println("Luas: " + obj.luas() + "\nVolume: " + obj.volume());
                        System.out.println("---------------------------------------");

                    }
                    case 2 -> {
                        System.out.print("P: "); double p = Double.parseDouble(sc.nextLine());
                        System.out.print("L: "); double l = Double.parseDouble(sc.nextLine());
                        System.out.print("T: "); double t = Double.parseDouble(sc.nextLine());
                        Balok obj = new Balok(p, l, t);
                        System.out.println("Luas: " + obj.luas() + "\nVolume: " + obj.volume());
                    }
                    case 3 -> {
                        System.out.print("Jari-jari: "); double r = Double.parseDouble(sc.nextLine());
                        Bola obj = new Bola(r);
                        System.out.println("Luas: " + obj.luas() + "\nVolume: " + obj.volume());
                    }
                    case 4 -> {
                        System.out.print("Jari-jari: "); double r = Double.parseDouble(sc.nextLine());
                        System.out.print("Tinggi: "); double t = Double.parseDouble(sc.nextLine());
                        Tabung obj = new Tabung(r, t);
                        System.out.println("Luas: " + obj.luas() + "\nVolume: " + obj.volume());
                    }
                    case 5 -> {
                        System.out.print("Sisi: "); double s = Double.parseDouble(sc.nextLine());
                        Persegi obj = new Persegi(s);
                        System.out.println("Luas: " + obj.luas() + "\nKeliling: " + obj.keliling());
                    }
                    case 6 -> {
                        System.out.print("P: "); double p = Double.parseDouble(sc.nextLine());
                        System.out.print("L: "); double l = Double.parseDouble(sc.nextLine());
                        PersegiPanjang obj = new PersegiPanjang(p, l);
                        System.out.println("Luas: " + obj.luas() + "\nKeliling: " + obj.keliling());
                    }
                    case 7 -> {
                        System.out.print("Jari-jari: "); double r = Double.parseDouble(sc.nextLine());
                        Lingkaran obj = new Lingkaran(r);
                        System.out.println("Luas: " + obj.luas() + "\nKeliling: " + obj.keliling());
                    }
                    case 8 -> {
                        System.out.print("Sisi 1: "); double s1 = Double.parseDouble(sc.nextLine());
                        System.out.print("Sisi 2: "); double s2 = Double.parseDouble(sc.nextLine());
                        System.out.print("Sisi 3: "); double s3 = Double.parseDouble(sc.nextLine());
                        System.out.print("Sisi 4: "); double s4 = Double.parseDouble(sc.nextLine());
                        System.out.print("Tinggi: "); double t = Double.parseDouble(sc.nextLine());
                        Trapesium obj = new Trapesium(s1, s2, s3, s4, t);
                        System.out.println("---------------------------------------");
                        System.out.println("Luas: " + obj.luas() + "\nKeliling: " + obj.keliling());
                        System.out.println("---------------------------------------");

                    }
                    default -> System.out.println("Pilihan 1-8 saja!");
                }
            } catch (Exception e) {
                System.out.println("Error: Masukkan angka yang valid!");
            }
        }
        sc.close();
    }
}