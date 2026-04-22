package Soal1;
public class BangunRuang {
    double luas() {
        return 0;
    }

    double volume() {
        return 0;
    }
}

class Kubus extends BangunRuang {
    double sisi;

    Kubus(double sisi) {
        this.sisi = sisi;
    }

    double luas() {
        return 6 * sisi * sisi;
    }

    double volume() {
        return sisi * sisi * sisi;
    }
}

class Balok extends BangunRuang {
    double p, l, t;

    Balok(double p, double l, double t) {
        this.p = p;
        this.l = l;
        this.t = t;
    }

    double luas() {
        return 2 * (p * l + p * t + l * t);
    }

    double volume() {
        return p * l * t;
    }
}

class Bola extends BangunRuang {
    double r;

    Bola(double r) {
        this.r = r;
    }

    double luas() {
        return 4 * Math.PI * r * r;
    }

    double volume() {
        return (4.0 / 3.0) * Math.PI * r * r * r;
    }
}

class Tabung extends BangunRuang {
    double r, t;

    Tabung(double r, double t) {
        this.r = r;
        this.t = t;
    }

    double luas() {
        return 2 * Math.PI * r * (r + t);
    }

    double volume() {
        return Math.PI * r * r * t;
    }
}