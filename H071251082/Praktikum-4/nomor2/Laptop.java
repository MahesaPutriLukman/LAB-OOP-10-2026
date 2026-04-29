package nomor2;

public class Laptop extends Product {
    int ramSize;
    String ProcessorType;
    public Laptop(String brand, int seriesNumber, double price, int ramSize, String processorType) {
        super(brand, seriesNumber, price);
        this.ramSize = ramSize;
        ProcessorType = processorType;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Processor Type: " + ProcessorType );
        System.out.println("Ram size: " + ramSize + " GB");
    }
}