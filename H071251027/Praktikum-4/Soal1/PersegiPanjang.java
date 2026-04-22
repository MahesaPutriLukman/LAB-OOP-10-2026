package Soal1;

class PersegiPanjang extends BangunDatar {

    double p,l;

    PersegiPanjang(double p,double l){
        this.p=p;
        this.l=l;
    }

    double luas(){
        return p*l;
    }

    double keliling(){
        return 2*(p+l);
    }
}