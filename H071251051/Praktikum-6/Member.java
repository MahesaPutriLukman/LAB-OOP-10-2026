import java.util.ArrayList;
import java.util.List;

public class Member {

    private String name;
    private int memberId;
    private List<LibraryItem> borrowedItems; 

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>(); 
    }

    // Method untuk meminjam item
    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed()) {
            throw new IllegalStateException("Item tidak tersedia, sedang dipinjam.");
        }

        String result = item.borrowItem(days);

        item.setBorrowed(true);

        borrowedItems.add(item);

        return "Item " + item.getTitle() + " berhasil dipinjam selama " + days + " hari";
    }

    public String returnItem(LibraryItem item, int daysLate) {

        item.returnItem();

        borrowedItems.remove(item);

        double fine = item.calculateFine(daysLate);

        String fineFormatted = formatRupiah(fine);

        return "Item " + item.getTitle() + " berhasil dikembalikan dengan denda: Rp " + fineFormatted;
    }

    // Method untuk mencetak daftar item yang sedang dipinjam
    public void getBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }

        // Cetak tabel dengan format yang rapi
        String border = "+------+--------------------+";
        System.out.println(border);
        System.out.printf("| %-4s | %-18s |%n", "ID", "Judul");
        System.out.println(border);
        for (LibraryItem item : borrowedItems) {
            System.out.printf("| %-4d | %-18s |%n", item.getItemId(), item.getTitle());
        }
        System.out.println(border);
    }

    private String formatRupiah(double amount) {
        int amountInt = (int) amount;
        String angka = String.valueOf(amountInt);
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = angka.length() - 1; i >= 0; i--) {
            if (count > 0 && count % 3 == 0) {
                result.insert(0, ".");
            }
            result.insert(0, angka.charAt(i));
            count++;
        }
        return result.toString();
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    public List<LibraryItem> getBorrowedItemsList() {
        return borrowedItems;
    }
}
