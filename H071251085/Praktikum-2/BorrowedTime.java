public class BorrowedTime {
    String name;
    int remainingLifeHours;
    SleepSession session; // atribut objek

    //default constructor
    public BorrowedTime() {
        this.name = "Unknown";
        this.remainingLifeHours = 700000; // rata-rata usia manusia dalam jam
        this.session = new SleepSession();
    }

    //constructor dengan parameter
    public BorrowedTime(String name, int lifeHours, SleepSession session) {
        this.name = name;
        this.remainingLifeHours = lifeHours;
        this.session = session;
    }

    //method mengurangi waktu hidup karena begadang
    public void pullAllNighter(int hours) {
        System.out.println(name + " begadang selama " + hours + "");

        remainingLifeHours -= hours;
        session.hoursAwake = hours;

        if (remainingLifeHours < 0) {
            remainingLifeHours = 0;
        }
    }

    //method interaksi antar objek sejenis
    public void compareWith(BorrowedTime other) {

        System.out.println("\n=== Comparing Life Time ===");

        if (this.remainingLifeHours > other.remainingLifeHours) {
            System.out.println(this.name + " memiliki waktu hidup lebih banyak dari " + other.name);
        }
        else if (this.remainingLifeHours < other.remainingLifeHours) {
            System.out.println(other.name + " memiliki waktu hidup lebih banyak dari " + this.name);
        }
        else {
            System.out.println("Keduanya memiliki waktu hidup yang sama.");
        }
    }

    //method cek status hidup
    public void checkStatus() {
        System.out.println("\nName: " + name);
        System.out.println("Remaining Life Hours: " + remainingLifeHours);
        session.showSession();
    }
}