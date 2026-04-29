package cobasaja;

public class Main {
    public static void main(String[] args) {
        Celengan aya = new Celengan ("yaya", "1234567");
        System.out.println("Nama Pemilik; " + aya.getNamaPemilik());
        System.out.println("Tipe Celengan: " + aya.tipeCelengan);

        aya.ubahPin("444444", "ll111");
        aya.ubahPin("1234567", "000003");

        aya.nabung(-100000);
        aya.nabung(200000);

        aya.bongkar(40000, "44454");
        aya.bongkar(40000, "000003");
    }

}
