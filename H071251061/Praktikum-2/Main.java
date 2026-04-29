public class Main {
    public static void main(String[] args) {
        Petani petani1 = new Petani("Asep Knalpot", 0);
        Petani petani2 = new Petani();

        petani2.menanam();
        
        petani1.cekGudang();
        petani2.cekGudang();

        petani1.bantuPanen(petani2);

        System.out.println("\nSetelah gotong royong panen:");
        petani1.cekGudang();
        petani2.cekGudang();
    }
}