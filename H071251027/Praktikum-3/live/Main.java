package live;

public class Main {
     public static void main(String[] args) {
        celengan celenganku = new celengan ("Aldo", "123456" );
        
        System.out.println("Nama Pemilik : " + celenganku.getNamaPemilik());
        System.out.println("Tipe Celengan : " + celenganku.tipeCelengan );

        System.out.println("1. Ubah PIN (PIN Lama Salah):");
        celenganku.ubahPin("000000", "654321");

        System.out.println("2. Ubah PIN (Syarat Benar):");
        celenganku.ubahPin("123456", "654321");

        System.out.println("3. Setor Tunai Negatif:");
        celenganku.setorTunai(-200000);

        System.out.println("4. Setor Tunai Valid:");
        celenganku.setorTunai(1000000);

        System.out.println("5. Tarik Tunai (PIN Lama):");
        celenganku.tarikTunai(300000, "123456");

        System.out.println("6. Tarik Tunai (PIN Baru):");
        celenganku.tarikTunai(300000, "654321");
}}
