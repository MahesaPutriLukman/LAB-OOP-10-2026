import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LibraryLogger {

    private List<String[]> logs; 

    public LibraryLogger() {
        this.logs = new ArrayList<>();
    }

    public String logActivity(String activity) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);

        String logEntry = timestamp + " " + activity;

        logs.add(new String[]{timestamp, activity, "-"});

        return logEntry;
    }

    public void logBorrow(String timestamp, String judul, String memberName) {
        logs.add(new String[]{timestamp, judul, memberName, "-"});
    }

    public void logReturn(String judul, String returnTimestamp) {
        for (String[] log : logs) {
            if (log[1].equals(judul) && log[3].equals("-")) {
                log[3] = returnTimestamp;
                break;
            }
        }
    }

    // Method untuk mendapatkan semua log dalam format tabel
    public String getLogs() {
        if (logs.isEmpty()) {
            return "Belum ada aktivitas.";
        }

        String border = "+-" + "-".repeat(19) + "-+-" + "-".repeat(30) + "-+-" + "-".repeat(15) + "-+-" + "-".repeat(19) + "-+";
        StringBuilder sb = new StringBuilder();

        sb.append(border).append("\n");
        sb.append(String.format("| %-19s | %-30s | %-15s | %-19s |%n",
                "Dipinjam pada", "Judul", "Member", "Dikembalikan pada"));
        sb.append(border).append("\n");

        for (String[] log : logs) {
            String dipinjamPada = log[0];
            String judul = log[1];
            String member = log.length > 2 ? log[2] : "-";
            String dikembalikan = log.length > 3 ? log[3] : "-";

            sb.append(String.format("| %-19s | %-30s | %-15s | %-19s |%n",
                    dipinjamPada, judul, member, dikembalikan));
        }

        sb.append(border);
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
    }

    public List<String[]> getLogsList() {
        return logs;
    }
}
