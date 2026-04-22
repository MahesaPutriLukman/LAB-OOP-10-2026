package Soal1;

class Balok extends BangunRuang {

    double p,l,t;

    Balok(double p,double l,double t){
        this.p=p;
        this.l=l;
        this.t=t;
    }

    double volume(){
        return p*l*t;
    }

    double luasPermukaan(){
        return 2*(p*l+p*t+l*t);
    }
}