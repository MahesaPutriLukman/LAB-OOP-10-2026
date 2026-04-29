package Soal1;
public class BangunDatar {
    double luas() {
        return 0;
    }

    double keliling() {
        return 0;
    }
}

class Persegi extends BangunDatar {
    double sisi;

    Persegi(double sisi) {
        this.sisi = sisi;
    }

    double luas() {
        return sisi * sisi;
    }

    double keliling() {
        return 4 * sisi;
    }
}

class PersegiPanjang extends BangunDatar {
    double p, l;

    PersegiPanjang(double p, double l) {
        this.p = p;
        this.l = l;
    }

    double luas() {
        return p * l;
    }

    double keliling() {
        return 2 * (p + l);
    }
}

class Lingkaran extends BangunDatar {
    double r;

    Lingkaran(double r) {
        this.r = r;
    }

    double luas() {
        return Math.PI * r * r;
    }

    double keliling() {
        return 2 * Math.PI * r;
    }
}

class Trapesium extends BangunDatar {
    double s1, s2, s3, s4, t;

    Trapesium(double s1, double s2, double s3, double s4, double t) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
        this.t = t;
    }

    double luas() {
        return 0.5 * (s1 + s2) * t;
    }

    double keliling() {
        return s1 + s2 + s3 + s4;
    }
}