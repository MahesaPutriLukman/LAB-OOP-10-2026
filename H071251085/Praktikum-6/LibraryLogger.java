import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class LibraryLogger {
    List<String> logs;
    DateTimeFormatter formatter;

    public LibraryLogger() {
        logs = new ArrayList<>();
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public String logActivity(String activity) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = timestamp + " | " + activity;
        logs.add(logEntry);
        return logEntry;
    }

    public String getLogs() {
        if (logs.isEmpty()) return "Tidak ada log";

        StringBuilder sb = new StringBuilder();
        for (String log : logs) {
            sb.append(log).append("\n");
        }
        return sb.toString();
    }

    public void clearLogs() {
        logs.clear();
    }
}