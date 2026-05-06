import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Library {

    private List<LibraryItem> items;     
    private List<Member> members;        
    private LibraryLogger logger;        

    // Constructor
    public Library() {
        this.items = new ArrayList<>();
        this.members = new ArrayList<>();
        this.logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.getTitle() + " berhasil ditambahkan";
    }

    public String addMember(Member member) {
        members.add(member);
        return member.getName() + " berhasil didaftarkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        throw new NoSuchElementException("Member dengan ID " + memberId + " tidak ditemukan.");
    }

    public String getLibraryStatus() {
        if (items.isEmpty()) {
            return "Tidak ada item di perpustakaan.";
        }

        String border = "+------+--------------------------------+------------+";
        StringBuilder sb = new StringBuilder();
        sb.append(border).append("\n");
        sb.append(String.format("| %-4s | %-30s | %-10s |%n", "ID", "Judul", "Status"));
        sb.append(border).append("\n");

        for (LibraryItem item : items) {
            String status = item.isBorrowed() ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-4d | %-30s | %-10s |%n",
                    item.getItemId(), item.getTitle(), status));
        }

        sb.append(border);
        return sb.toString();
    }

    public String borrowItem(int memberId, int itemId, int days) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);

        // member.borrow() akan lempar exception jika ada masalah
        String result = member.borrow(item, days);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);

        String tipe = (item instanceof Book) ? "Buku" : "DVD";
        logger.logBorrow(timestamp, item.getTitle(), member.getName());

        return result;
    }

    // Proses pengembalian item oleh member
    public String returnItem(int memberId, int itemId, int daysLate) {
        Member member = findMemberById(memberId);
        LibraryItem item = findItemById(itemId);

        String result = member.returnItem(item, daysLate);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = now.format(formatter);
        logger.logReturn(item.getTitle(), timestamp);

        return result;
    }

    // Ambil semua log dari logger
    public String getAllLogs() {
        return logger.getLogs();
    }

    public List<LibraryItem> getItems() {
        return items;
    }

    public List<Member> getMembers() {
        return members;
    }
}
