package Tugas2;

public class Product {
    String brand;
    int seriesNumber;
    double price;

    public Product(String brand, int seriesNumber, double price) {
        this.brand = brand;
        this.seriesNumber = seriesNumber;
        this.price = price;
    }

    public void displayInfo() {
        System.out.print("Merek: " + brand + " | No. Seri: " + seriesNumber + " | Harga: Rp" + price);
    }
}