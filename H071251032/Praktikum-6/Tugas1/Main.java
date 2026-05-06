import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library perpus = new Library();
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        while (true) {
            System.out.println("\n---------------------------------------");
            System.out.println("=== Sistem Manajemen Perpustakaan ===");
            System.out.println("---------------------------------------");
            System.out.println("1. Tambah Item\n2. Tambah Anggota\n3. Pinjam Item\n4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan\n6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota\n8. Keluar");
            System.out.println("---------------------------------------");
            System.out.print("Pilih menu: ");

            int pilihan = 0;
            try {
                pilihan = input.nextInt();
                
                if (pilihan == 1) {
                    boolean tipeValid = false;
                    while (!tipeValid) {
                        try {
                            System.out.print("Tipe (1.Buku / 2.DVD): ");
                            int tipe = input.nextInt();
                            input.nextLine(); 

                            if (tipe == 1) {
                                System.out.print("Judul: "); String judul = input.nextLine();
                                System.out.print("ID Barang: "); int id = input.nextInt();
                                input.nextLine(); 
                                System.out.print("Penulis: "); String penulis = input.nextLine();
                                
                                String hasil = perpus.addItem(new Book(judul, id, penulis));
                                System.out.println(hasil);
                                if (!hasil.startsWith("ERROR")) tipeValid = true;
                            } else if (tipe == 2) {
                                System.out.print("Judul: "); String judul = input.nextLine();
                                System.out.print("ID Barang: "); int id = input.nextInt();
                                System.out.print("Durasi (menit): "); int durasi = input.nextInt();
                                
                                String hasil = perpus.addItem(new DVD(judul, id, durasi));
                                System.out.println(hasil);
                                if (!hasil.startsWith("ERROR")) tipeValid = true;
                            } else {
                                System.out.println("Pilihan tipe salah!");
                            }
                        } catch (Exception e) {
                            System.out.println("Input salah!");
                            input.nextLine();
                        }
                    }

                } else if (pilihan == 2) {
                    try {
                        input.nextLine(); 
                        System.out.print("Nama Member: "); String nama = input.nextLine();
                        System.out.print("ID Member: "); int idM = input.nextInt();
                        System.out.println(perpus.addMember(new Member(nama, idM))); 
                    } catch (Exception e) {
                        System.out.println("Gagal: ID harus angka.");
                        input.nextLine();
                    }
                    
                } else if (pilihan == 3) {
                    try {
                        System.out.print("ID Member: "); int idMem = input.nextInt();
                        Member m = perpus.findMemberById(idMem);
                        System.out.print("ID Barang: "); int idBar = input.nextInt();
                        LibraryItem barang = perpus.findItemById(idBar);
                        System.out.print("Berapa hari dipinjam? "); int hari = input.nextInt();
                        
                        // Eksekusi pinjam
                        System.out.println(m.borrow(barang, hari));
                        
                        // Catat ke logger (Sistem simpan durasi 'hari')
                        perpus.getLibraryLogger().logPinjam(LocalDateTime.now(), barang.getTitle(), m.getName(), idBar, hari);

                    } catch (Exception e) {
                        System.out.println("Gagal pinjam: " + e.getMessage());
                        input.nextLine();
                    }

                } else if (pilihan == 4) {
                    try {
                        System.out.print("ID Member: "); int idMem = input.nextInt();
                        Member m2 = perpus.findMemberById(idMem);
                        System.out.print("ID Barang: "); int idBar = input.nextInt();
                        LibraryItem b2 = perpus.findItemById(idBar);
                        
                        // User hanya perlu input keterlambatan
                        System.out.print("Telat berapa hari? (Isi 0 jika tidak): "); int telat = input.nextInt();
                        
                        // Eksekusi kembali
                        System.out.println(m2.returnItem(b2, telat));
                        
                        // Logger otomatis hitung tanggal kembali
                        perpus.getLibraryLogger().updateLogKembali(idBar, m2.getName(), telat, dtf);

                    } catch (Exception e) {
                        System.out.println("Gagal kembali: " + e.getMessage());
                        input.nextLine();
                    }

                } else if (pilihan == 5) {
                    perpus.getLibraryStatus();
                } else if (pilihan == 6) {
                    // Panggil fungsi tabel dari logger
                    System.out.println(perpus.getLibraryLogger().generateTabelLog(dtf));
                } else if (pilihan == 7) {
                    try {
                        System.out.print("ID Member: ");
                        int idMem = input.nextInt();
                        Member m = perpus.findMemberById(idMem);
                        if (m != null) m.getBorrowedItems();
                    } catch (Exception e) {
                        System.out.println("Gagal cek pinjaman.");
                        input.nextLine();
                    }
                } else if (pilihan == 8) {
                    System.out.println("Keluar program...");
                    break;
                }
            } catch (Exception e) {
                System.out.println("Gunakan angka untuk memilih menu!");
                input.nextLine(); 
            }
        }
        input.close();
    }
}