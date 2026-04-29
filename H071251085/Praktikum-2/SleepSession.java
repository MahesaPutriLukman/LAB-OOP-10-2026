public class SleepSession {
    int hoursAwake;
    String activity;

    //default constructor
    public SleepSession() {
        this.hoursAwake = 0;
        this.activity = "None";
    }

    //constructor dengan parameter
    public SleepSession(int hoursAwake, String activity) {
        this.hoursAwake = hoursAwake;
        this.activity = activity;
    }

    //method untuk menampilkan info begadang
    public void showSession() {
        System.out.println("Activity: " + activity);
        System.out.println("Hours Awake: " + hoursAwake);
    }
}


