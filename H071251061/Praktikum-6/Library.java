class Library {
    private LibraryItem[] items = new LibraryItem[50];
    private Member[] members = new Member[50];
    private int itemCount = 0;
    private int memberCount = 0;
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem item) {
        items[itemCount++] = item;
        return item.getTitle() + " berhasil ditambahkan";
    }

    public void addMember(Member member) {
        members[memberCount++] = member;
    }

    public LibraryItem findItemById(int itemId) {
        for (int i = 0; i < itemCount; i++) {
            if (items[i].getItemId() == itemId) return items[i];
        }
        throw new java.util.NoSuchElementException("Item dengan ID " + itemId + " tidak ditemukan.");
    }

    public Member findMemberById(int memberId) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i].getMemberId() == memberId) return members[i];
        }
        throw new java.util.NoSuchElementException("Member ID tidak ditemukan.");
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("+-----+-----------------+-----------+\n");
        sb.append("| ID  | Judul           | Status    |\n");
        sb.append("+-----+-----------------+-----------+\n");
        for (int i = 0; i < itemCount; i++) {
            String status = items[i].isBorrowed ? "Dipinjam" : "Tersedia";
            sb.append(String.format("| %-3d | %-15s | %-9s |\n", items[i].getItemId(), items[i].getTitle(), status));
        }
        sb.append("+-----+-----------------+-----------+");
        return sb.toString();
    }

    public LibraryLogger getLogger() { return logger; }
}