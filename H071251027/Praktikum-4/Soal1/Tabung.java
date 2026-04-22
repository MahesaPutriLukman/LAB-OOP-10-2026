package Soal1;

class Tabung extends BangunRuang {

    double r,t;

    Tabung(double r,double t){
        this.r=r;
        this.t=t;
    }

    double volume(){
        return Math.PI*r*r*t;
    }

    double luasPermukaan(){
        return 2*Math.PI*r*(r+t);
    }
}