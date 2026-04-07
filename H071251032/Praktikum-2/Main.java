package QuidditchCompetition;

public class Main {
    public static void main(String[] args) {
        // membuat sapu untuk masing-masing pemain
        SapuTerbang firebolt = new SapuTerbang("Firebolt", 80);
        SapuTerbang nimbus = new SapuTerbang("Nimbus 2001", 80);

        //membuat objek pemain Quidditch
        PemainQuidditch harry = new PemainQuidditch("Harry Potter", 80, firebolt);
        PemainQuidditch malfoy = new PemainQuidditch("Draco Malfoy", 80, nimbus);

        System.out.println("--- KONDISI AWAL PERTANDINGAN ---");
        harry.cekStatus();
        malfoy.cekStatus();

        //Harry merawat sapunya terlebihdahulu
        // harry.rawatSapu();
        // harry.cekStatus();

        //Simulasi duel perebutan bola 
        harry.rebutanQuaffle(malfoy);

        System.out.println("\n--- KONDISI AKHIR SETELAH DUEL ---");
        harry.cekStatus();
        malfoy.cekStatus();
    }
    
}
