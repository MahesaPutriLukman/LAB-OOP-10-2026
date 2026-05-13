import java.util.*;

public class perpus {

    // list untuk menyimpan semua barang di perpustakaan
    List<BarangPerpus> barang = new ArrayList<>();

    // list untuk menyimpan semua member
    List<member> Member = new ArrayList<>();

    // object logger untuk mencatat aktivitas
    PerpusLogger logger = new PerpusLogger();
   
    // Method cek id duplikat 
    boolean isIdExist(int id){
        // loop semua item
        for (BarangPerpus b : barang) {
            // jika ID sama, berarti sudah ada
            if (b.ID == id) {
                return true;
            }
        }
        // jika tidak ditemukan
        return false;
    }

    // method tambahkan Item
    String addItem(BarangPerpus item){

        // cek panjang judul maksimal 30 karakter
        if (item.judul.length() > 30){
            System.out.println("Judul terlalu panjang.");
            return "Gagal menambahkan item.";
        }

        // cek id maksimal 4 digit
        if (String.valueOf(item.ID).length() > 4){
            System.out.println("ID melebihi batas.");
            return "Gagal menambahkan item.";
        }

        // cek id duplikat
        if (isIdExist(item.ID)) {
            System.out.println("ID sudah digunakan.");
            return "Gagal menambahkan item.";
        }

        // menambahkan item ke list barang
        barang.add(item);

        // mengembalikan pesan berhasil
        return item.judul + " berhasil ditambahkan";
    }

    // method untuk menambahkan member
    void addMember(member member){

        // cek panjang nama
        if (member.nama.length() > 30){
            System.out.println("Nama terlalu panjang.");
            return;
        }

        // cek panjang id
        if (String.valueOf(member.memberID).length() > 4){
            System.out.println("ID member melebihi batas.");
            return;
        }

        // simpan member ke list
        Member.add(member);

        // tampilkan pesan
        System.out.println("Member: [" + member.nama + "] berhasil ditambahkan.");
    }

    // mencari item berdasarkan ID
    public BarangPerpus findItemById(int id) {
        // loop semua item
        for (BarangPerpus item : barang) {
            if (item.ID == id) {
                return item; // jika ditemukan
            }
        }
        // jika tidak ditemukan, lempar error
        throw new NoSuchElementException("Item tidak ditemukan");
    }

    // menampilkan status semua item di perpustakaan
    String getLibraryStatus(){

        // jika tidak ada item
        if (barang.isEmpty()){
            return "Belum ada item di perpustakaan.";
        }

        String hasil = "Status Perpustakaan:\n";

        // loop semua item
        for (BarangPerpus item : barang){

            // cek status item
            String status = item.pinjaman ? "Dipinjam" : "Tersedia";

            // gabungkan deskripsi + status
            hasil += item.getDescription() + " | Status: " + status + "\n";
        }

        // kembalikan hasil
        return hasil;
    }

    // menampilkan semua log aktivitas
    public String getAllLogs(){
        // ambil data log dari logger
        return logger.getLogs(); // sesuai petunjuk harus kembalikan log dari logger
    }
}