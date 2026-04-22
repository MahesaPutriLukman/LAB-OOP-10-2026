package Soal1;

class Persegi extends BangunDatar {

    double sisi;

    Persegi(double sisi){
        this.sisi = sisi;
    }

    double luas(){
        return sisi*sisi;
    }

    double keliling(){
        return 4*sisi;
    }
}