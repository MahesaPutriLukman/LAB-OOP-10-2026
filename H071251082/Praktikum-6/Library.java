import java.util.NoSuchElementException;

class Library {
    LibraryItem[] items;
    int itemCount;
    Member[] members;
    int memberCount;
    LibraryLogger logger;

    public Library() {
        this.items = new LibraryItem[100]; 
        this.itemCount = 0;
        
        this.members = new Member[50];     
        this.memberCount = 0;
        
        this.logger = new LibraryLogger();
    }

    public String addItem(LibraryItem item) {
        if (this.itemCount >= this.items.length) {
            return "Gagal: Kapasitas rak perpustakaan penuh.";
        }

        for (int i = 0; i < this.itemCount; i++) {
            if (this.items[i].itemId == item.itemId) {
                return "Gagal: ID item sudah digunakan.";
            }
        }

        this.items[this.itemCount] = item;
        this.itemCount++;
        return item.title + " berhasil ditambahkan";
    }

    public LibraryItem findItemById(int itemId) {
        for (int i = 0; i < this.itemCount; i++) {
            if (this.items[i].itemId == itemId) {
                return this.items[i];
            }
        }
        throw new NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public String getLibraryStatus() {
        if (this.itemCount == 0) {
            return "Perpustakaan kosong, belum ada item.";
        }

        StringBuilder table = new StringBuilder();
        String horizontalLine = "+-------+----------------------+------------+\n";

        table.append(horizontalLine);
        table.append(String.format("| %-5s | %-20s | %-10s |\n", "ID", "Judul", "Status"));
        table.append(horizontalLine);

        for (int i = 0; i < this.itemCount; i++) {
            LibraryItem item = this.items[i];
            String status = item.isBorrowed ? "Dipinjam" : "Tersedia";
            table.append(String.format("| %-5d | %-20s | %-10s |\n", item.itemId, item.title, status));
        }

        table.append(horizontalLine);
        return table.toString();
    }

    public String getAllLogs() {
        return this.logger.getLogs();
    }

    public String addMember(Member member) {
        if (this.memberCount >= this.members.length) {
            return "Gagal: Kapasitas member penuh.";
        }

        for (int i = 0; i < this.memberCount; i++) {
            if (this.members[i].memberId == member.memberId) {
                return "Gagal: ID member sudah digunakan.";
            }
        }

        this.members[this.memberCount] = member;
        this.memberCount++;
        return "Member " + member.name + " berhasil ditambahkan";
    }

    public Member findMemberById(int memberId) {
        for (int i = 0; i < this.memberCount; i++) {
            if (this.members[i].memberId == memberId) {
                return this.members[i];
            }
        }
        throw new NoSuchElementException("Member dengan ID " + memberId + " tidak ditemukan.");
    }

    public void borrowItem(int memberId, int itemId, int days) {
        try {
            Member member = findMemberById(memberId);
            LibraryItem item = findItemById(itemId);

            String result = member.borrow(item, days);
            System.out.println(result);

            System.out.println(logger.logActivity("PINJAM", item.title, member.name));
            
        } catch (Exception e) {
            System.out.println("Gagal meminjam: " + e.getMessage());
        }
    }

    public void returnItem(int memberId, int itemId, int daysLate) {
        try {
            Member member = findMemberById(memberId);
            LibraryItem item = findItemById(itemId);

            String result = member.returnItem(item, daysLate);
            System.out.println(result);

            System.out.println(logger.logActivity("KEMBALI", item.title, member.name));
            
        } catch (Exception e) {
            System.out.println("Gagal mengembalikan: " + e.getMessage());
        }
    }
}