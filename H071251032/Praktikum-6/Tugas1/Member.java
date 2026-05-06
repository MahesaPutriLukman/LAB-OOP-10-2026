import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems; // Daftar barang yang sedang dibawa member

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(LibraryItem item, int days) {
        // Jika status item sudah dipinjam, lempar exception sesuai soal
        if (item.getIsBorrowed() == true) {
            throw new IllegalStateException("Item tidak tersedia (sudah dipinjam)");
        }
        
        String hasil = item.borrowItem(days);
        borrowedItems.add(item); // Masukkan ke kantong pinjaman member
        return hasil;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        double denda = item.calculateFine(daysLate);
        item.returnItem(); // Reset status item jadi tersedia
        borrowedItems.remove(item); // Hapus dari kantong pinjaman member
        
        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + denda;
    }

    public void getBorrowedItems() {
        System.out.println("Item yang sedang dipinjam oleh: " + this.name);
        
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam.");
            return;
        }

        String border = "+--------+---------------------------------+";
        String header = "| ID     | Judul Item                      |";
        
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
        
        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-6d | %-31s |\n", 
                            item.getItemId(), item.getTitle());
        }
        System.out.println(border);
    }

    public String getName() { return name; }
    public int getMemberId() { return memberId; }
}