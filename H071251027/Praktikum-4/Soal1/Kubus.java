package Soal1;

class Kubus extends BangunRuang {

    double s;

    Kubus(double s){
        this.s=s;
    }

    double volume(){
        return s*s*s;
    }

    double luasPermukaan(){
        return 6*s*s;
    }
}