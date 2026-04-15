package Soal2;

public class Main{
    public static void main(String[] args) {
        CelenganDigital celengan1 = new CelenganDigital("Alifah", "20012007");

        System.out.println("Nama pemilik adalah " + celengan1.getNamaPemilik());
        System.out.println("Tipe celengan adalah " + celengan1.tipeCelengan + "\n");

        celengan1.setUbahPin("00000000", "12345678");
        celengan1.setUbahPin("20012007", "12345678");

        celengan1.Nabung(-100000);
        celengan1.Nabung(1000000);

        celengan1.Bongkar(30, "00000000");
        celengan1.Bongkar(30, "12345678");
    }
}