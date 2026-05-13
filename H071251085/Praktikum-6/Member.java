import java.util.ArrayList;
import java.util.List;

class Member {
    String name, memberID;
    List<LibraryItem> borrowedItems = new ArrayList<>();

    String borrow(LibraryItem item, int days) {
        if (item.isBorrowed) {
            throw new IllegalStateException("Item tidak tersedia (sudah dipinjam)");
        }

        item.borrowItem(days); 

        borrowedItems.add(item);
        return "Item " + item.title + " berhasil dipinjam selama " + days + " hari";
    }

    String returnItem (LibraryItem item, int daysLate){
        if (!borrowedItems.contains(item)) {
            throw new IllegalArgumentException("Item tidak ada dalam daftar pinjaman");
        }

        borrowedItems.remove(item);
        item.returnItem();
        double hitung = item.calculateFine(daysLate);

        return "Item " + item.title + " berhasil dikembalikan dengan denda: Rp " + hitung;
    }

    void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }

        System.out.println("+------+----------------+");
        System.out.println("| ID   | Judul          |");
        System.out.println("+------+----------------+");

        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-4d | %-14s |\n", item.itemID, item.title);
        }

        System.out.println("+------+----------------+");
    }
}