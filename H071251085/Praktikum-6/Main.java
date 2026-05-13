import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");
            
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                continue;
            }

            try {
                switch (choice) {
                    case 1:
                        Boolean ulang = true;
                        while (ulang) {
                            System.out.print("Jenis Item (1: Buku, 2: DVD): ");
                            int type = Integer.parseInt(scanner.nextLine());
                            if (type == 1) {
                                System.out.print("ID Item: ");
                                int itemId = Integer.parseInt(scanner.nextLine());

                                System.out.print("Judul: ");
                                String title = scanner.nextLine();

                                System.out.print("Penulis: ");
                                String author = scanner.nextLine();

                                System.out.println(library.addItem(new Book(title, itemId, author)));
                                ulang = false;

                            } else if (type == 2) {
                                System.out.print("ID Item: ");
                                int itemId = Integer.parseInt(scanner.nextLine());

                                System.out.print("Judul: ");
                                String title = scanner.nextLine();

                                System.out.print("Durasi (menit): ");
                                String duration = scanner.nextLine();

                                System.out.println(library.addItem(new DVD(title, itemId, duration)));
                                ulang = false;

                            } else {
                                System.out.println("Jenis item tidak valid.");
                                continue;
                            }
                        }
                        break;

                    case 2:
                        System.out.print("ID Member: ");
                        String memberId =scanner.nextLine().toUpperCase();
                        System.out.print("Nama: ");
                        String name = scanner.nextLine().toUpperCase();

                        Member member = new Member();
                        member.name = name;
                        member.memberID = memberId;

                        System.out.println(library.addMember(member));
                        break;

                    case 3:
                        System.out.print("ID Member: ");
                        String mIdBorrow = scanner.nextLine().toUpperCase();
                        System.out.print("ID Item: ");
                        int iIdBorrow = Integer.parseInt(scanner.nextLine());
                        System.out.print("Durasi Pinjam (hari): ");
                        int days = Integer.parseInt(scanner.nextLine());

                        Member memberBorrow = library.findMemberById(mIdBorrow);
                        LibraryItem itemBorrow = library.findItemById(iIdBorrow);

                        String borrowResult = memberBorrow.borrow(itemBorrow, days);
                        System.out.println(borrowResult);

                
                        String itemType = itemBorrow instanceof Book ? "BUKU" : "DVD";
                        library.logger.logActivity(itemType + " '" + itemBorrow.title + "' dipinjam oleh " + memberBorrow.name);
                        break;

                    case 4:
                        System.out.print("ID Member: ");
                        String mIdReturn =scanner.nextLine().toUpperCase();
                        
                        System.out.print("ID Item: ");
                        int iIdReturn = Integer.parseInt(scanner.nextLine());
                        System.out.print("Keterlambatan (hari, 0 jika tidak telat): ");
                        int daysLate = Integer.parseInt(scanner.nextLine());

                        Member memberReturn = library.findMemberById(mIdReturn);
                        LibraryItem itemReturn = library.findItemById(iIdReturn);

                        String returnResult = memberReturn.returnItem(itemReturn, daysLate);
                        System.out.println(returnResult);
                    
                        String itemTypeRet = itemReturn instanceof Book ? "Buku" : "DVD";
                        library.logger.logActivity(itemTypeRet + " '" + itemReturn.title + "' dikembalikan oleh " + memberReturn.name);
                        break;

                    case 5:
                        System.out.println("\nStatus Perpustakaan:");
                        System.out.print(library.getLibraryStatus());
                        break;

                    case 6:
                        System.out.println("\nLog Aktivitas:");
                        System.out.println(library.getAllLogs());
                        break;

                    case 7:
                        System.out.print("ID Member: ");
                        String mIdView = scanner.nextLine().toUpperCase();
                        Member memberView = library.findMemberById(mIdView);
                        System.out.println("\nItem yang dipinjam oleh " + memberView.name + ":");
                        memberView.getBorrowedItems();
                        break;

                    case 8:
                        System.out.println("Keluar dari sistem...");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan yang tidak terduga: " + e.getMessage());
            }
        }
    }
}