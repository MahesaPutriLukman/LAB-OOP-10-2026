package Soal1;

public class Main {
    public static void main(String[] args) {

        DompetDigital akun1 =
            new DompetDigital("Alifah", "112233");

        System.out.println("Nama Pemilik: " + akun1.getNamaPemilik() + "\n");

        akun1.setGantiPin("000000", "445566");

        akun1.setGantiPin("112233", "445566");

        akun1.setor(100000);

        akun1.setor(-5000);

        akun1.tarik(20000, "112233");

        akun1.tarik(20000, "445566");

        System.out.println("Saldo akhir: "
                + akun1.getSaldo());

    }

}