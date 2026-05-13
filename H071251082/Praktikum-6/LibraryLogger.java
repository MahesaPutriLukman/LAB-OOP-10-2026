import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LibraryLogger {
    class LogRecord {
        String title;
        String memberName;
        LocalDateTime borrowDate;
        LocalDateTime returnDate;

        LogRecord(String title, String memberName, LocalDateTime borrowDate) {
            this.title = title;
            this.memberName = memberName;
            this.borrowDate = borrowDate;
            this.returnDate = null; 
        }
    }

    LogRecord[] logs;
    int logCount;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    LibraryLogger() {
        this.logs = new LogRecord[100]; 
        this.logCount = 0; 
    }

    String logActivity(String action, String title, String memberName) {
        LocalDateTime now = LocalDateTime.now();
        String timestamp = now.format(formatter);

        if (action.equalsIgnoreCase("PINJAM")) {
            if (this.logCount >= this.logs.length) {
                return "Gagal: Memori log sudah penuh (Maksimal " + this.logs.length + ").";
            }

            this.logs[this.logCount] = new LogRecord(title, memberName, now);
            this.logCount++; 
            
            return timestamp + " " + title + " dipinjam oleh " + memberName;
            
        } else if (action.equalsIgnoreCase("KEMBALI")) {
            for (int i = this.logCount - 1; i >= 0; i--) { 
                LogRecord record = this.logs[i];

                if (record.title.equals(title) && record.memberName.equals(memberName) && record.returnDate == null) {

                    record.returnDate = now;
                    return timestamp + " " + title + " dikembalikan oleh " + memberName;
                }
            }
        }
        return "Gagal: Aktivitas tidak valid atau data peminjaman tidak ditemukan.";
    }

    String getLogs() {
        if (this.logCount == 0) {
            return "Tidak ada log aktivitas.";
        }

        StringBuilder table = new StringBuilder();
        String horizontalLine = "+---------------------+----------------------+-----------------+---------------------+\n";
        
        table.append(horizontalLine);
        table.append(String.format("| %-19s | %-20s | %-15s | %-19s |\n", "Dipinjam pada", "Judul", "Member", "Dikembalikan pada"));
        table.append(horizontalLine);

        for (int i = 0; i < this.logCount; i++) {
            LogRecord record = this.logs[i];
            String borrowStr = record.borrowDate.format(formatter);
            String returnStr = (record.returnDate != null) ? record.returnDate.format(formatter) : "-";

            table.append(String.format("| %-19s | %-20s | %-15s | %-19s |\n", borrowStr, record.title, record.memberName, returnStr));
        }

        table.append(horizontalLine);
        return table.toString();
    }

    void clearLogs() {
        for (int i = 0; i < this.logs.length; i++) {
            this.logs[i] = null;
        }
        this.logCount = 0;
        System.out.println("Log aktivitas telah dikosongkan.");
    }
}