package Soal1;

class Bola extends BangunRuang {

    double r;

    Bola(double r){
        this.r=r;
    }

    double volume(){
        return (4.0/3.0)*Math.PI*r*r*r;
    }

    double luasPermukaan(){
        return 4*Math.PI*r*r;
    }
}   