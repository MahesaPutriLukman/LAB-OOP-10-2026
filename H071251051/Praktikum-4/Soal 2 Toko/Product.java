public class Product {

    protected String brand;
    protected int    seriesNumber;
    protected double price;

    public Product(String brand, int seriesNumber, double price) {
        this.brand        = brand;
        this.seriesNumber = seriesNumber;
        this.price        = price;
    }

    public String getBrand()        { return brand; }
    public int    getSeriesNumber() { return seriesNumber; }
    public double getPrice()        { return price; }

    // Method dasar di parent
    public void displayInfo() {
        System.out.println("Brand: "          + brand);
        System.out.println("Serial Number: "  + seriesNumber);
        System.out.println("Price: Rp"        + price);
    }
}