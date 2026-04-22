public class Smartphone extends Product {

    private double screenSize;
    private int    storageCapacity;

    public Smartphone(String brand, int seriesNumber, double price,
                      double screenSize, int storageCapacity) {
        super(brand, seriesNumber, price);
        this.screenSize      = screenSize;
        this.storageCapacity = storageCapacity;
    }

    // displayInfo
    public void displayInfo() {
        System.out.println("Brand: "            + brand);
        System.out.println("Serial Number: "    + seriesNumber);
        System.out.println("Price: Rp"          + price);
        System.out.println("Screen Size: "      + screenSize      + " inches");
        System.out.println("Storage Capacity: " + storageCapacity + "GB");
    }
}