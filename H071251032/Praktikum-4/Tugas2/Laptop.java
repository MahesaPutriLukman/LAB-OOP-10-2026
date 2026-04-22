package Tugas2;

public class Laptop extends Product {
    int ramSize;
    String processor;

    public Laptop(String brand, int series, double price, int ramSize, String processor) {
        super(brand, series, price);
        this.ramSize = ramSize;
        this.processor = processor;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println(" | RAM: " + ramSize + "GB | CPU: " + processor);
    }
}