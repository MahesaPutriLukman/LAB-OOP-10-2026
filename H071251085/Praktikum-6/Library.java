import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Library {
    List<LibraryItem> items = new ArrayList<>();
    List<Member> members = new ArrayList<>();
    LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items.add(item);
        return item.title + " berhasil ditambahkan";
    }

    public String addMember(Member member) {
        members.add(member);
        return "Member " + member.name + " berhasil ditambahkan";
    }

    LibraryItem findItemById(int itemId) {
        for (LibraryItem item : items) {
            if (item.itemID == itemId) {
                return item;
            }
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    Member findMemberById(String memberid) {
        for (Member member : members) {
            if (member.memberID.equals(memberid)) {
                return member;
            }
        }
        throw new NoSuchElementException("Member dengan ID " + memberid + " tidak ditemukan.");
    }

    public String getLibraryStatus() {
        if (items.isEmpty()) return "Perpustakaan kosong.";
        StringBuilder sb = new StringBuilder();
        sb.append("+-------+--------------------------------+------------+\n");
        sb.append("| ID    | Judul                          | Status     |\n");
        sb.append("+-------+--------------------------------+------------+\n");
        for (LibraryItem item : items) {
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-5d | %-30s | %-10s |\n", item.itemID, item.title, status));
        }
        sb.append("+-------+--------------------------------+------------+\n");
        return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogs();
    }
}