package Soal2;

class Produk {
    String brand;
    int serialNumber;
    double price;

    Produk (String brand, int serialNumber, double price) {
        this.brand = brand;
        this.serialNumber = serialNumber;
        this.price = price;
    }

    void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Serial Number: " + serialNumber);
        System.out.println("Price: $"+ price);
    }
}
    class Smartphone extends Produk {
    double screenSize;
    int storageCapacity;

    Smartphone(String brand, int serialNumber, double price, double screenSize, int storageCapacity) {
        super(brand, serialNumber, price);
        this.screenSize = screenSize;
        this.storageCapacity = storageCapacity;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Screen Size: " + screenSize + " inches");
        System.out.println("Storage Capacity: " + storageCapacity + "GB");
    }
}

class Camera extends Produk {
    int resolution;
    String lensType;

    Camera(String brand, int serialNumber, double price, int resolution, String lensType) {
        super(brand, serialNumber, price);
        this.resolution = resolution;
        this.lensType = lensType;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("Resolution: " + resolution + "MP");
        System.out.println("Lens Type: " + lensType);
    }
}

class Laptop extends Produk {
    int ramSize;
    String processorType;

    Laptop(String brand, int serialNumber, double price, int ramSize, String processorType) {
        super(brand, serialNumber, price);
        this.ramSize = ramSize;
        this.processorType = processorType;
    }

    void displayInfo() {
        super.displayInfo();
        System.out.println("RAM Size: " + ramSize + "GB");
        System.out.println("Processor Type: " + processorType);
    }
}
