package Soal2;

class Smartphone extends Product {

    double screenSize;
    int storage;

    Smartphone(String brand,int series,double price,
               double screenSize,int storage){

        super(brand,series,price);
        this.screenSize = screenSize;
        this.storage = storage;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Screen Size: " + screenSize + " inches");
        System.out.println("Storage Capacity: " + storage + "GB\n");
    }
}