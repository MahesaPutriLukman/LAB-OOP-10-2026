package Tugas2;

public class Smartphone extends Product {
    double screenSize;
    int storage;

    public Smartphone(String brand, int series, double price, double screenSize, int storage) {
        super(brand, series, price);
        this.screenSize = screenSize;
        this.storage = storage;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println(" | Layar: " + screenSize + " inci | Storage: " + storage + "GB");
    }
}