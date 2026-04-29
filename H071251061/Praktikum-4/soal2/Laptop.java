package soal2;
public class Laptop extends Product {
    int ramSize;
    String processorType;

    Laptop(String brand, int sn, double pr, int ram, String proc) {
        super(brand, sn, pr);
        this.ramSize = ram;
        this.processorType = proc;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Processor Type: " + processorType);
        System.out.println("RAM Size: " + ramSize + "GB");
    }
}