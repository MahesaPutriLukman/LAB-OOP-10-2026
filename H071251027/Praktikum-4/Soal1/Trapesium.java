package Soal1;

class Trapesium extends BangunDatar {

    double a,b,c,d,t;
    //a dan b = sisi sejajar
    //c dan d = sisi miring 
    //t = tinggi  

    Trapesium(double a,double b,double c,double d,double t){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
        this.t=t;
    }

    double luas(){
        return 0.5*(a+b)*t;
    }

    double keliling(){
        return a+b+c+d;
    }
}