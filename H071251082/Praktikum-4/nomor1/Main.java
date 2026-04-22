package nomor1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        System.out.println("-----------------------------------------");
        System.out.println("   ==== BANGUN RUANG ====");
        System.out.println("1. KUBUS");
        System.out.println("2. BALOK");
        System.out.println("3. BOLA");
        System.out.println("4. TABUNG");
        System.out.println();
        System.out.println("   ==== BANGUN DATAR ====");
        System.out.println("5. PERSEGI");
        System.out.println("6. PERSEGI PANJANG");
        System.out.println("7. LINGKARAN");
        System.out.println("8. TRAPESIUM");
        System.out.println("-----------------------------------------");

        try {
            System.out.print("Pilihan: ");
        int pilihan = x.nextInt();
        System.out.println("-----------------------------------------");

        switch(pilihan){
            case 1:
            System.out.print("Masukkan sisi kubus: ");
            double sisiKubus = x.nextInt();
            Kubus kubus = new Kubus(sisiKubus);
            System.out.println("Luas permukaan kubus: " + kubus.luasPermukaan());
            System.out.println("Volume kubus: " + kubus.volume());
            break;

            case 2:
            System.out.print("Masukkan panjang balok: ");
            double panjangBalok = x.nextInt();
            System.out.print("Masukkan lebar balok: ");
            double lebarBalok = x.nextInt();
            System.out.print("Masukkan tinggi balok: ");
            double tinggiBalok = x.nextInt();
            Balok balok = new Balok(panjangBalok, lebarBalok, tinggiBalok);
            System.out.println("Luas permukaan balok: " +  balok.luasPermukaan());
            System.out.println("Volume balok: " + balok.volume());
            break;

            case 3:
            System.out.print("Masukkan jari-jari bola: ");
            double jariJariBola = x.nextInt();
            Bola bola = new Bola(jariJariBola);
            System.out.printf("Luas permukaan bola: %.2f\n" ,  bola.luasPermukaan());
            System.out.printf("Volume bola: %.2f\n" , bola.volume());
            break;

            case 4:
            System.out.print("Masukkan jari-jari tabung: ");
            double jariJariTabung = x.nextInt();
            System.out.print("Masukkan tinggi tabung: ");
            double tinggiTabung = x.nextInt();
            Tabung tabung = new Tabung(jariJariTabung, tinggiTabung);
            System.out.printf("Luas permukaan tabung: %.2f\n" , tabung.luasPermukaan());
            System.out.printf("Volume balok: %.2f\n" , tabung.volume());
            break;

            case 5:
            System.out.print("Masukkan sisi persegi: ");
            double sisiPersegi = x.nextInt();
            Persegi persegi = new Persegi(sisiPersegi);
            System.out.println("Keliling persegi: " +  persegi.keliling());
            System.out.println("Luas persegi: " + persegi.luas());
            break;

            case 6:
            System.out.print("Masukkan panjang persegi panjang: ");
            double panjangPersegiPanjang = x.nextInt();
            System.out.print("Masukkan lebar persegi panjang: ");
            double lebarPersegiPanjang = x.nextInt();
            PersegiPanjang persegiPanjang = new PersegiPanjang(panjangPersegiPanjang,lebarPersegiPanjang);
            System.out.println("Keliling persegi panjang: " +  persegiPanjang.keliling());
            System.out.println("Luas persegi panjang: " + persegiPanjang.luas());
            break;

            case 7:
            System.out.print("Masukkan jari-jari lingkaran: ");
            double jariJariLingkaran = x.nextInt();
            Lingkaran lingkaran = new Lingkaran(jariJariLingkaran);
            System.out.printf("Keliling lingkaran: %.2f\n" ,  lingkaran.keliling());
            System.out.printf("Luas lingkaran: %.2f" , lingkaran.luas());
            break;

            case 8:
            System.out.print("Masukkan sisi 1 trapesium: ");
            double sisi1 = x.nextInt();
            System.out.print("Masukkan sisi 2 trapesium: ");
            double sisi2 = x.nextInt();
            System.out.print("Masukkan sisi 3 trapesium: ");
            double sisi3 = x.nextInt();
            System.out.print("Masukkan sisi 4 trapesium: ");
            double sisi4 = x.nextInt();
            System.out.print("Masukkan tinggi trapesium: ");
            double tinggiTrapesium = x.nextInt();
            Trapesium trapesium = new Trapesium(sisi1, sisi2, sisi3, sisi4, tinggiTrapesium);
            System.out.println("Keliling trapesium: " +  trapesium.keliling());
            System.out.println("Luas trapesium: " + trapesium.luas());
            break;

            default:
            System.out.println("Pilihan hanya 1-8");
        }   
        } catch (Exception e) {
            System.out.println("Inputan hanya berupa angka.");
        }
    }
}
