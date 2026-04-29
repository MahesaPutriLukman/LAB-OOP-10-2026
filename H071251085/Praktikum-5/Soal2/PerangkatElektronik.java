package Soal2;

abstract class PerangkatElektronik {
    String merk;
    int dayaListrik;

    PerangkatElektronik(String merk, int dayaListrik) {
        this.merk = merk;
        this.dayaListrik = dayaListrik;
    }
    
    abstract String cekFungsi();

    void infoPower (){
        System.out.printf("Perangkat sedang menyedot daya sebesar %d Watt ", dayaListrik);
    }
}



