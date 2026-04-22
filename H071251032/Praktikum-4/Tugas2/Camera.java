package Tugas2;

public class Camera extends Product {
    int resolution;
    String lensType;

    public Camera(String brand, int series, double price, int resolution, String lensType) {
        super(brand, series, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println(" | Res: " + resolution + "MP | Lensa: " + lensType);
    }
}