public class Laptop extends Product {

    private int    ramSize;
    private String processorType;

    public Laptop(String brand, int seriesNumber, double price,
        int ramSize, String processorType) {
        super(brand, seriesNumber, price);
        this.ramSize       = ramSize;
        this.processorType = processorType;
    }

    // displau
    public void displayInfo() {
        System.out.println("Brand: "          + brand);
        System.out.println("Serial Number: "  + seriesNumber);
        System.out.println("Price: Rp"        + price);
        System.out.println("Processor Type: " + processorType);
        System.out.println("RAM Size: "       + ramSize + "GB");
    }
}