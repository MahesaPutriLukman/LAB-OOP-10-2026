public class Trapesium extends BangunDatar {
    private double s1, s2, s3, s4, t;
    public Trapesium(double s1, double s2, double s3, double s4, double t) {
        this.s1 = s1; 
        this.s2 = s2; 
        this.s3 = s3; 
        this.s4 = s4; 
        this.t = t;
    }

    public double luas() { return 0.5 * (s1 + s2) * t; }
    
    public double keliling() { return s1 + s2 + s3 + s4; }
}