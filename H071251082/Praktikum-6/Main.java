import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        Library library = new Library();
        boolean jalan = true;

        while (jalan) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Masukkan pilihan menu: ");

            if (!x.hasNextInt()) {
                System.out.println("Input harus angka!");
                x.nextLine();
                continue;
            }

            int pilih = x.nextInt();
            x.nextLine();

            try {
                switch (pilih) {
                    case 1:
                        System.out.print(" Pilih tipe item (1 Buku / 2 DVD): ");
                        int t = x.nextInt();
                        x.nextLine();

                        if(t != 1 && t != 2){
                            System.out.println("Tipe tidak valid.");
                            continue;
                        }
                        System.out.print("ID: ");
                        int id = x.nextInt();
                        x.nextLine();

                        System.out.print("Judul: ");
                        String title = x.nextLine();

                        if (t == 1) {
                            System.out.print("Author: ");
                            String author = x.nextLine();
                            System.out.println(library.addItem(new Book(title, id, author)));
                        } else {
                            System.out.print("Durasi: ");
                            int dur = x.nextInt();
                            x.nextLine();
                            System.out.println(library.addItem(new DVD(title, id, dur)));
                        }
                        break;

                    case 2:
                        System.out.print("ID: ");
                        int mid = x.nextInt();
                        x.nextLine();

                        System.out.print("Nama: ");
                        String name = x.nextLine();

                        System.out.println(library.addMember(new Member(name, mid)));
                        break;

                    case 3:
                        if (library.memberCount == 0 || library.itemCount == 0) {
                            System.out.println("Belum ada member atau item untuk dipinjam.");
                            break;
                        }
                        System.out.print("Member ID: ");
                        int m = x.nextInt();
                        x.nextLine();
                        System.out.print("Item ID: ");
                        int i = x.nextInt();
                        x.nextLine();
                        System.out.print("Hari: ");
                        int d = x.nextInt();
                        x.nextLine();

                        if(d <= 0){
                            System.out.println("Jumlah hari harus lebih dari 0.");
                            break;
                        }

                        library.borrowItem(m, i, d);
                        break;

                    case 4:
                        if (library.memberCount == 0 || library.itemCount == 0) {
                            System.out.println("Belum ada member atau item untuk dikembalikan.");
                            break;
                        }       
                        System.out.print("Member ID: ");
                        int m2 = x.nextInt();
                        x.nextLine();
                        System.out.print("Item ID: ");
                        int i2 = x.nextInt();
                        x.nextLine();
                        System.out.print("Terlambat: ");
                        int l = x.nextInt();
                        x.nextLine();

                        library.returnItem(m2, i2, l);
                        break;

                    case 5:
                        System.out.println(library.getLibraryStatus());
                        break;

                    case 6:
                        System.out.println(library.getAllLogs());
                        break;

                    case 7:
                        if (library.memberCount == 0) {
                            System.out.println("Belum ada member.");
                            break;
                        }
                        System.out.print("ID Member: ");
                        int cari = x.nextInt();
                        x.nextLine();

                        try{
                            Member mem = library.findMemberById(cari);
                            mem.getBorrowedItems();
                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 8:
                        System.out.println("Terima kasih sudah menggunakan jasa kami.");
                        jalan = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}