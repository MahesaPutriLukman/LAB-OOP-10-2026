import java.util.*;

public class member {

    // atribut untuk menyimpan nama member
    String nama;

    // atribut untuk menyimpan ID member
    int memberID;

    // list untuk menyimpan data item yang sedang dipinjam
    List<BarangPerpus> dataItemPinjaman;

    // constructor untuk mengisi nama dan ID member
    member(String nama, int memberID){
        this.nama = nama;
        this.memberID = memberID;
        dataItemPinjaman = new ArrayList<>(); // inisialisasi list kosong
    }

    // method untuk meminjam item
    String meminjam(BarangPerpus item, int Days){
        try {
            // memanggil method pinjamBarang dari item
            item.pinjamBarang(Days);

            // jika berhasil, tambahkan item ke daftar pinjaman
            dataItemPinjaman.add(item);

            return "Item [" + item.judul + "] berhasil dipinjam selama " + Days + " hari";

        } catch (IllegalArgumentException e) {
            // jika gagal, lempar exception sesuai instruksi
            throw new IllegalStateException("Item sedang dipinjam atau tidak valid");
        }
    }

    // method untuk mengembalikan item
    String mengembalikan(BarangPerpus item, int DaysLate){

        // cek apakah item memang dipinjam oleh member ini
        if (!dataItemPinjaman.contains(item)) {
            throw new IllegalStateException("Item ini tidak dipinjam oleh member ini");
        }

        // ubah status item menjadi tidak dipinjam
        item.BarangKembali();

        // hapus item dari daftar pinjaman
        dataItemPinjaman.remove(item);

        // jika tidak ada keterlambatan
        if (DaysLate == 0){
            return "Item [" + item.judul + "] berhasil dikembalikan dengan denda: Rp 0";
        }

        // jika ada keterlambatan, tampilkan denda
        return "Item [" + item.judul + "] berhasil dikembalikan dengan denda: Rp "
                + item.tenggatWaktu(DaysLate);
    }

    // method untuk menampilkan daftar item yang sedang dipinjam
    void tabelDataPinjamanMember(){

        // jika tidak ada pinjaman
        if (dataItemPinjaman.isEmpty()){
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }

        // menampilkan daftar pinjaman
        System.out.println("Daftar Pinjaman Member:");

        // loop untuk menampilkan setiap item
        for (BarangPerpus item : dataItemPinjaman){
            System.out.println("- ID: " + item.ID + " | Judul: " + item.judul);
        }
    }
}