 class Member {
    String name;
    int memberId;
    LibraryItem[] borrowedItems;
    int itemCount;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new LibraryItem[5];
        this.itemCount = 0;
    }

    public String borrow(LibraryItem item, int days){
        if(this.itemCount >= 5){
            throw new IllegalStateException("Anda hanya dapat meminjam sebanyak 5 item.");
        }

        String result = item.borrowItem(days);
        this.borrowedItems[this.itemCount] = item;
        this.itemCount++;

        return result;
    }

    public String returnItem(LibraryItem item, int daysLate){
        boolean isFound = false;

        for(int i = 0; i < this.itemCount; i++){
            if(this.borrowedItems[i] == item){
                isFound = true;

                for (int j = i; j < this.itemCount-1; j++){
                    this.borrowedItems[j] = this.borrowedItems[j+1];
                }

                this.borrowedItems[this.itemCount -1 ] = null;
                this.itemCount--;
                break;
            }
        }

        if(!isFound){
            return "Gagal: Item tidak ditemukan di daftar peminjaman";
        }

        double denda = item.calculateFine(daysLate);
        item.returnItem();

        return "Item " + item.title + " berhasil dikembalikan dengan denda sebesar Rp " + denda;
    }

    public void getBorrowedItems(){
        if(this.itemCount == 0){
            System.out.println("Tidak ada item yang dipinjam.");
            return;
        }
        
        System.out.println("+-------+----------------------+");
        System.out.println("| ID    | Judul                |");
        System.out.println("+-------+----------------------+");

        for(int i = 0; i < this.itemCount; i++){
            LibraryItem item  = this.borrowedItems[i];
            System.out.printf("| %-5d | %-20s |\n", item.itemId, item.title);
        }

        System.out.println("+-------+----------------------+");
    }
}