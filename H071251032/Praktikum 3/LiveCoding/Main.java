package LiveCoding;

public class Main {
    public static void main(String[] args){
        Celengan rembo = new Celengan ("12345", "wawa");

        System.out.println("\n=========================");
        System.out.println("nama pemilik: " + rembo.getNamaPemilik());
        System.out.println("Tipe Celengan: " + rembo.tipeCelengan);
        System.out.println("=========================\n");

        System.out.println("------------------------------------------------------------------------");
        rembo.ubahPin("000000", "654321"); //ubah pin tapi salah
        rembo.ubahPin("12345", "54321"); // ubah pin tapi benar

        rembo.menabung(-78000); //menabung nominal negatif
        rembo.menabung(500000); //menabung nominal positif
        
        rembo.membongkar(50000, "00000"); //bongkar pin salah
        rembo.membongkar(50000, "54321"); //bongkar pin benar
        System.out.println("-------------------------------------------------------------------------\n");
    }
}
