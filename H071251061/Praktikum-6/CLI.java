import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item\n2. Tambah Anggota\n3. Pinjam Item\n4. Kembalikan Item\n5. Lihat Status Perpustakaan\n6. Lihat Log Aktivitas\n7. Lihat Item yang Dipinjam Anggota\n8. Keluar");
            System.out.print("Pilih menu: ");
            
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Masukkan angka 1-8!");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Tipe (1. Buku / 2. DVD): ");
                        int type = Integer.parseInt(sc.nextLine());
                        System.out.print("Judul: "); String title = sc.nextLine();
                        System.out.print("ID: "); int id = Integer.parseInt(sc.nextLine());
                        if (type == 1) {
                            System.out.print("Author: "); String author = sc.nextLine();
                            System.out.println(lib.addItem(new Book(title, id, author)));
                        } else {
                            System.out.print("Durasi (menit): "); int dur = Integer.parseInt(sc.nextLine());
                            System.out.println(lib.addItem(new DVD(title, id, dur)));
                        }
                        break;

                    case 2:
                        System.out.print("Nama: "); String name = sc.nextLine();
                        System.out.print("Member ID: "); int mid = Integer.parseInt(sc.nextLine());
                        lib.addMember(new Member(name, mid));
                        System.out.println("Member berhasil ditambahkan.");
                        break;

                    case 3:
                        System.out.print("Member ID: "); int mIdP = Integer.parseInt(sc.nextLine());
                        System.out.print("Item ID: "); int iIdP = Integer.parseInt(sc.nextLine());
                        System.out.print("Durasi Pinjam (hari): "); int days = Integer.parseInt(sc.nextLine());
                        
                        Member mP = lib.findMemberById(mIdP);
                        LibraryItem iP = lib.findItemById(iIdP);
                        
                        System.out.println(mP.borrow(iP, days));
                        
                        String tipeP = (iP instanceof Book) ? "[Buku]" : "[DVD]";
                        lib.getLogger().logBorrow(iP.getTitle(), mP.getName());
                        break;

                    case 4:
                        System.out.print("Member ID: "); int mIdK = Integer.parseInt(sc.nextLine());
                        System.out.print("Item ID: "); int iIdK = Integer.parseInt(sc.nextLine());
                        System.out.print("Keterlambatan (hari): "); int late = Integer.parseInt(sc.nextLine());
                        
                        Member mK = lib.findMemberById(mIdK);
                        LibraryItem iK = lib.findItemById(iIdK);

                        System.out.println(mK.returnItem(iK, late));
                        
                        String tipeK = (iK instanceof Book) ? "[Buku]" : "[DVD]";
                        lib.getLogger().logReturn(iK.getTitle());
                        break;

                    case 5:
                        System.out.println(lib.getLibraryStatus());
                        break;

                    case 6:
                        System.out.println(lib.getLogger().getLogs());
                        break;

                    case 7:
                        System.out.print("Member ID: "); int mIdL = Integer.parseInt(sc.nextLine());
                        lib.findMemberById(mIdL).displayBorrowedItems();
                        break;

                    case 8:
                        System.out.println("Keluar sistem...");
                        System.exit(0);

                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}