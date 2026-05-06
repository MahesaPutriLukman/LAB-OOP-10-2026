import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PerpusLogger {

    // class ini dipakai untuk menyimpan satu data aktivitas log
    static class logData {
        String judul; 
        String NamaMember;            
        String waktuPinjamItem;       
        String waktuKembalikanItem;   

        // constructor ini dipakai saat item dipinjam, dan langsung menyimpan data awal peminjaman
        logData(String judul, String NamaMember, String pinjamItem){
            this.judul = judul;
            this.NamaMember = NamaMember;
            this.waktuPinjamItem = pinjamItem;
            this.waktuKembalikanItem = "-"; // tanda belum dikembalikan
        }
    }

    // list ini menyimpan semua riwayat aktivitas perpustakaan
    List<logData> catatanAktivitas;

    // format waktu agar rapi (tahun-bulan-hari jam:menit:detik)
    DateTimeFormatter formatWaktu;

    // constructor utama, dijalankan saat objek dibuat
    public PerpusLogger() {
        catatanAktivitas = new ArrayList<>(); // buat list kosong
        formatWaktu = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // format waktu
    }

    // method ini dipanggil saat item dipinjam
    void logPinjamItem(String judul, String NamaMember){

        // ambil waktu saat ini
        String waktuPinjam = LocalDateTime.now().format(formatWaktu);

        // simpan data peminjaman ke dalam list log
        catatanAktivitas.add(new logData(judul, NamaMember, waktuPinjam));
    }

    // method ini dipanggil saat item dikembalikan
    void logKembalikanItem(String judul, String NamaMember){

        // ambil waktu saat pengembalian
        String waktuKembali = LocalDateTime.now().format(formatWaktu);

        // cari data peminjaman yang belum dikembalikan
        for (logData log : catatanAktivitas){
            if (log.judul.equals(judul) &&
                log.NamaMember.equals(NamaMember) &&
                log.waktuKembalikanItem.equals("-")) {

                // isi waktu pengembalian
                log.waktuKembalikanItem = waktuKembali;
                break; // berhenti setelah ketemu
            }
        }
    }

    // method untuk menampilkan semua riwayat log
    public String getLogs(){

        // kalau belum ada aktivitas
        if (catatanAktivitas.isEmpty()){
            return "belum ada aktivitas.";
        }

        String hasil = "";

        // tampilkan semua data log satu per satu
        for (logData log : catatanAktivitas) {

            // tampilkan data peminjaman
            hasil += log.waktuPinjamItem + " " + log.judul +
                     " dipinjam oleh " + log.NamaMember + "\n";

            // kalau sudah dikembalikan, tampilkan juga
            if (!log.waktuKembalikanItem.equals("-")) {
                hasil += log.waktuKembalikanItem + " " + log.judul +
                         " dikembalikan oleh " + log.NamaMember + "\n";
            }
        }

        return hasil;
    }

    // method untuk menghapus semua riwayat log
    public void clearLogs() {
        catatanAktivitas.clear(); // kosongkan semua data
        System.out.println("log berhasil dikosongkan.");
    }
}