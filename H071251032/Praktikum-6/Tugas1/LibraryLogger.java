import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LibraryLogger {
    // Inner class untuk menyimpan detail setiap baris log
    private class LogEntry {
        LocalDateTime waktuPinjamObj;
        String judul;
        String member;
        String waktuKembaliStr;
        int idBarang;
        int durasiAwal;

        LogEntry(LocalDateTime waktu, String judul, String member, int id, int durasi) {
            this.waktuPinjamObj = waktu;
            this.judul = judul;
            this.member = member;
            this.idBarang = id;
            this.durasiAwal = durasi;
            this.waktuKembaliStr = "-"; // Default saat baru pinjam
        }
    }

    private ArrayList<LogEntry> daftarLog = new ArrayList<>();

    // Dipanggil saat Menu 3 (Pinjam)
    public void logPinjam(LocalDateTime waktu, String judul, String member, int id, int durasi) {
        daftarLog.add(new LogEntry(waktu, judul, member, id, durasi));
    }

    // Dipanggil saat Menu 4 (Kembali) - OTOMATIS HITUNG TANGGAL
    public void updateLogKembali(int id, String namaMember, int telat, DateTimeFormatter dtf) {
        for (LogEntry entry : daftarLog) {
            // Cari baris yang ID barang & nama membernya cocok, dan belum dikembalikan
            if (entry.idBarang == id && entry.member.equalsIgnoreCase(namaMember) && entry.waktuKembaliStr.equals("-")) {
                
                // LOGIKA: Tanggal Pinjam + Durasi Peminjaman + Hari Terlambat
                LocalDateTime tglKembaliObj = entry.waktuPinjamObj.plusDays(entry.durasiAwal + telat);
                entry.waktuKembaliStr = tglKembaliObj.format(dtf);
                return; 
            }
        }
        System.out.println("Data peminjaman tidak ditemukan di log.");
    }

    // Untuk menampilkan tabel (Menu 6)
    public String generateTabelLog(DateTimeFormatter dtf) {
        if (daftarLog.isEmpty()) return "Belum ada aktivitas.";

        StringBuilder sb = new StringBuilder();
        String header = String.format("| %-19s | %-20s | %-12s | %-19s |", 
                        "Dipinjam pada", "Judul", "Member", "Dikembalikan pada");
        
        sb.append("+---------------------+----------------------+--------------+---------------------+\n");
        sb.append(header).append("\n");
        sb.append("+---------------------+----------------------+--------------+---------------------+\n");

        for (LogEntry e : daftarLog) {
            String baris = String.format("| %-19s | %-20s | %-12s | %-19s |", 
                           e.waktuPinjamObj.format(dtf), e.judul, e.member, e.waktuKembaliStr);
            sb.append(baris).append("\n");
        }
        sb.append("+---------------------+----------------------+--------------+---------------------+");
        return sb.toString();
    }

    public String getLogs() {
    // Kita buat formatter default di sini supaya Library.java tidak eror
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return generateTabelLog(dtf);
    }
}