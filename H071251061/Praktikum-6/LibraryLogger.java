import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LogEntry {
    String borrowDate;
    String title;
    String memberName;
    String returnDate;

    public LogEntry(String borrowDate, String title, String memberName) {
        this.borrowDate = borrowDate;
        this.title = title;
        this.memberName = memberName;
        this.returnDate = "-";
    }
}

class LibraryLogger {
    private LogEntry[] logs = new LogEntry[100];
    private int logCount = 0;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void logBorrow(String title, String memberName) {
        if (logCount < logs.length) {
            String now = LocalDateTime.now().format(formatter);
            logs[logCount++] = new LogEntry(now, title, memberName);
        }
    }

    public void logReturn(String title) {
        String now = LocalDateTime.now().format(formatter);
        for (int i = 0; i < logCount; i++) {
            if (logs[i].title.equals(title) && logs[i].returnDate.equals("-")) {
                logs[i].returnDate = now;
                break;
            }
        }
    }

    public String getLogs() {
        if (logCount == 0) return "Belum ada log aktivitas.";
        
        StringBuilder sb = new StringBuilder();
        String line = "+---------------------+--------------------------------+--------------+---------------------+\n";
        sb.append(line);
        sb.append("| Dipinjam pada       | Judul                          | Member       | Dikembalikan pada   |\n");
        sb.append(line);
        
        for (int i = 0; i < logCount; i++) {
            sb.append(String.format("| %-19s | %-30s | %-12s | %-19s |\n",
                logs[i].borrowDate,
                logs[i].title,
                logs[i].memberName,
                logs[i].returnDate));
        }
        sb.append(line);
        return sb.toString();
    }
}