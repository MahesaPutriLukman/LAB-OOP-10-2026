import java.util.*;

public class Library {
    private List<LibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public String addItem(LibraryItem newItem) {
        // 1. Cek apakah ID sudah ada di daftar items
        for (LibraryItem existingItem : items) {
            if (existingItem.getItemId() == newItem.getItemId()) {
                // Kita jelaskan ID-nya tabrakan dengan barang apa
                return String.format(
                    "Gagal Tambah: ID [%d] sudah digunakan oleh %s [%s]. Silakan gunakan ID lain!", 
                    newItem.getItemId(), 
                    (existingItem instanceof Book ? "Buku" : "DVD"),
                    existingItem.getTitle()
                );
            }
        }
        
        // 2. Jika aman, baru tambahkan
        items.add(newItem);
        return "Berhasil: " + newItem.getTitle() + " ditambahkan ke sistem.";
    }

    public String addMember(Member newMember) {
        for (Member m : members) {
            if (m.getMemberId() == newMember.getMemberId()) {
                return "GAGAL: ID Member " + m.getMemberId() + " sudah terdaftar atas nama [" + m.getName() + "].";
            }
        }
        members.add(newMember);
        return "SUKSES: Member [" + newMember.getName() + "] berhasil ditambahkan.";
    }

    public LibraryItem findItemById(int idCari) {
        for (LibraryItem barang : items) {
            if (barang.getItemId() == idCari) {
                return barang;
            }
        }
        throw new NoSuchElementException("Barang dengan ID " + idCari + " tidak ditemukan.");
    }

    public Member findMemberById(int idMember) {
        for (Member m : members) {
            if (m.getMemberId() == idMember) {
                return m;
            }
        }
        throw new NoSuchElementException("Member tidak ditemukan.");
    }

    public void getLibraryStatus() {
        String border = "+--------+---------------------------------+--------------+";
        String header = "| ID     | Judul                           | Status       |";
        
        System.out.println(border);
        System.out.println(header);
        System.out.println(border);
        
        for (LibraryItem item : items) {
            String status = item.getIsBorrowed() ? "Dipinjam" : "Tersedia";
            // %-6d = angka ID rata kiri lebar 6
            // %-31s = teks judul rata kiri lebar 31
            // %-12s = teks status rata kiri lebar 12
            System.out.printf("| %-6d | %-31s | %-12s |\n", 
                            item.getItemId(), item.getTitle(), status);
        }
        System.out.println(border);
    }

    public LibraryLogger getLibraryLogger() {
        return this.logger;
    }
    
    public String ambilSemuaLog() { return logger.getLogs(); }
}