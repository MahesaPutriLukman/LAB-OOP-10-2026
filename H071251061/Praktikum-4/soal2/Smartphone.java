package soal2;
public class Smartphone extends Product {
    double screenSize;
    int storageCapacity;

    Smartphone(String brand, int sn, double pr, double ss, int sc) {
        super(brand, sn, pr);
        this.screenSize = ss;
        this.storageCapacity = sc;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Screen Size: " + screenSize + " inches");
        System.out.println("Storage Capacity: " + storageCapacity + "GB");
    }
}