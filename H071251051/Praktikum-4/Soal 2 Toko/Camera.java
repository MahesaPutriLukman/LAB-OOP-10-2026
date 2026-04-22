public class Camera extends Product {

    private int    resolution;
    private String lensType;

    public Camera(String brand, int seriesNumber, double price,
                  int resolution, String lensType) {
        super(brand, seriesNumber, price);
        this.resolution = resolution;
        this.lensType   = lensType;
    }

    // displayInfo
    public void displayInfo() {
        System.out.println("Brand: "         + brand);
        System.out.println("Serial Number: " + seriesNumber);
        System.out.println("Price: Rp"       + price);
        System.out.println("Resolution: "    + resolution + "MP");
        System.out.println("Lens Type: "     + lensType);
    }
}