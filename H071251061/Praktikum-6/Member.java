class Member {
    private String name;
    private int memberId;
    private LibraryItem[] borrowedItems;
    private int borrowedCount;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new LibraryItem[10];
        this.borrowedCount = 0;
    }

    public String borrow(LibraryItem item, int days) {
        if (item.isBorrowed) throw new IllegalStateException("Item tidak tersedia (sudah dipinjam).");
        String message = item.borrowItem(days);
        borrowedItems[borrowedCount++] = item;
        return message;
    }

    public String returnItem(LibraryItem item, int daysLate) {
        double fine = item.calculateFine(daysLate);
        item.returnItem();
        
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedItems[i].getItemId() == item.getItemId()) {
                borrowedItems[i] = borrowedItems[borrowedCount - 1];
                borrowedItems[borrowedCount - 1] = null;
                borrowedCount--;
                break;
            }
        }
        return String.format("Item %s berhasil dikembalikan dengan denda: Rp %,.0f", item.getTitle(), fine);
    }

    public void displayBorrowedItems() {
        if (borrowedCount == 0) {
            System.out.println("Tidak ada item yang dipinjam");
            return;
        }
        System.out.println("+-----+-----------------+");
        System.out.println("| ID  | Judul           |");
        System.out.println("+-----+-----------------+");
        for (int i = 0; i < borrowedCount; i++) {
            System.out.printf("| %-3d | %-15s |\n", borrowedItems[i].getItemId(), borrowedItems[i].getTitle());
        }
        System.out.println("+-----+-----------------+");
    }

    public String getName() { return name; }
    public int getMemberId() { return memberId; }
}


