package Soal2;

class Laptop extends Product {

    int ram;
    String processor;

    Laptop(String brand,int series,double price,
           int ram,String processor){

        super(brand,series,price);
        this.ram = ram;
        this.processor = processor;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Processor Type: " + processor);
        System.out.println("RAM Size: " + ram + "GB\n");
    }
}