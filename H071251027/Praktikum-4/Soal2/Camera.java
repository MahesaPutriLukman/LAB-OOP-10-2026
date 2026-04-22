package Soal2;

class Camera extends Product {

    String resolution;
    String lens;

    Camera(String brand,int series,double price,
           String resolution,String lens){

        super(brand,series,price);
        this.resolution = resolution;
        this.lens = lens;
    }

    void displayInfo(){
        super.displayInfo();
        System.out.println("Resolution: " + resolution);
        System.out.println("Lens Type: " + lens + "\n");
    }
}