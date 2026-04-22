package soal2;
public class Camera extends Product {
    int resolution;
    String lensType;

    Camera(String brand, int sn, double pr, int res, String lens) {
        super(brand, sn, pr);
        this.resolution = res;
        this.lensType = lens;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Resolution: " + resolution + "MP");
        System.out.println("Lens Type: " + lensType);
    }
}