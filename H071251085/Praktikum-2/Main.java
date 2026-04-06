public class Main {
    public static void main(String[] args) {

        SleepSession s1 = new SleepSession(5, "Coding Project");
        SleepSession s2 = new SleepSession(8, "Gaming");

        BorrowedTime person1 =
                new BorrowedTime("Alifah", 700000, s1);

        BorrowedTime person2 =
                new BorrowedTime("Rani", 700000, s2);

        person1.pullAllNighter(8);
        person2.pullAllNighter(8);

        //cek status
        person1.checkStatus();
        person2.checkStatus();

        //interaksi antar objek
        person1.compareWith(person2);
    }
}



