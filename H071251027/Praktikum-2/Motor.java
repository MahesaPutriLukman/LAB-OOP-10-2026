public class Motor {
    private String merk;
    private int bensin;

    public Motor() {
        this.merk = "Standar";
        this.bensin = 5;
    }

    public Motor(String merk, int bensin) {
        this.merk = merk;
        this.bensin = bensin;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public int getBensin() {
        return bensin;
    }

    public void setBensin(int bensin) {
        this.bensin = bensin;
    }
}