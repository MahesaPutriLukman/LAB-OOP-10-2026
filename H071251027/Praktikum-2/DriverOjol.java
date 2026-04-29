public class DriverOjol {
    // 3 Attribute
    private String nama;
    private int saldo;
    private Motor motor;

    // Constructor 1
    public DriverOjol() {
        this.nama = "Driver Baru";
        this.saldo = 0;
        this.motor = new Motor();
    }

    // Constructor 2: 
    public DriverOjol(String nama, int saldo, Motor motor) {
        this.nama = nama;
        this.saldo = saldo;
        this.motor = motor;
    }

    // Getters 
    public String getNama() { return nama; }
    public int getSaldo() { return saldo; }
    public Motor getMotor() { return motor; }

    // Behavior 1:
    public void terimaOrder(int jarak) {
        int konsumsi = jarak * 2;
        System.out.println(nama + " menerima order sejauh " + jarak + " km.");
        
        if (motor.getBensin() >= konsumsi) {
            motor.setBensin(motor.getBensin() - konsumsi);
            saldo += jarak * 1000;
            System.out.println("Order selesai. Sisa bensin motor: " + motor.getBensin() + " liter.");
        } else {
            System.out.println("Gagal. Sisa bensin motor hanya: " + motor.getBensin() + " liter.");
        }
    }

    // Behavior 2: 
    public void tukarMotor(DriverOjol rekan) {
        Motor temp = this.motor;
        this.motor = rekan.motor;
        rekan.motor = temp;
        System.out.println(this.nama + " dan " + rekan.nama + " berhasil menukar motor.");
    }
}