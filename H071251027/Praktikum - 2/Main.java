public class Main {
    public static void main(String[] args) {
        Motor m1 = new Motor("Honda", 10);
        Motor m2 = new Motor("Yamaha", 8);

        DriverOjol driver1 = new DriverOjol("Aldo", 50000, m1);
        DriverOjol driver2 = new DriverOjol("Reyhan", 30000, m2);

        System.out.println("Saldo awal " + driver1.getNama() + ": " + driver1.getSaldo());
        System.out.println("Saldo awal " + driver2.getNama() + ": " + driver2.getSaldo());

        driver1.terimaOrder(3);

        System.out.println("Saldo setelah order " + driver1.getNama() + ": " + driver1.getSaldo());

        driver1.tukarMotor(driver2);

        System.out.println("Motor " + driver1.getNama() + " sekarang: " + driver1.getMotor().getMerk());
        System.out.println("Motor " + driver2.getNama() + " sekarang: " + driver2.getMotor().getMerk());

        System.out.println("Saldo akhir " + driver1.getNama() + ": " + driver1.getSaldo());
        System.out.println("Saldo akhir " + driver2.getNama() + ": " + driver2.getSaldo());
    }
}