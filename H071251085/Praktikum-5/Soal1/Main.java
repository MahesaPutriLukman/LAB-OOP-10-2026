package Soal1;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nama Karyawan: ");
        String nama = scan.nextLine().toUpperCase();
        
        System.out.print("ID Karyawan: ");
        String idKaryawan = scan.nextLine().toUpperCase();
        
        String kategori;

        do {
            try {
                System.out.print("Kategori Karyawan (Karyawan Tetap (1) / Karyawan Kontrak (2)): ");
                kategori = scan.nextLine();
                
                if (kategori.equals("1")) {
                    KaryawanTetap karyawan = new KaryawanTetap(nama, idKaryawan);
                    
                    System.out.print("Masukkan jumlah kehadiran yang ingin diinput: ");
                    int jumlah = scan.nextInt();
                    scan.nextLine();
                    int i = 1;

                    for (;i <= jumlah;) {
                        System.out.print("Apakah karyawan hadir? (y/n): ");
                        String jawaban = scan.nextLine().toLowerCase();
                        
                        if (jawaban.endsWith("y")){
                            karyawan.absen();
                            i++;
                        } else if (jawaban.endsWith("n")){
                            i++;
                            continue;
                            
                        } else {
                            System.out.println("Pilihan tidak valid");
                            continue;
                        }
                    }
                
                    System.out.println("\nNama karyawan: " + karyawan.getnama());
                    System.out.println("ID karyawan: " + karyawan.getIdKaryawan());
                    System.out.print("Total gaji dan bonus Anda " + karyawan.hitungGaji(1000000));
                    
                } else if (kategori.equals("2")) {
                    KaryawanKontrak karyawan = new KaryawanKontrak(nama, idKaryawan);
                    
                    int jumlah;
                    
                    do {
                        System.out.print("Masukkan jumlah kehadiran yang ingin diinput: ");
                        jumlah = scan.nextInt();
                            scan.nextLine();
                            
                            if (jumlah < 21) {
                                System.out.println("Jumlah harus 20 atau lebih, ulangi!");
                            }
                        } while (jumlah < 21);

                        int hadir;
                        int tidakHadir;

                        do {
                            System.out.print("Masukkan jumlah hadir: ");
                            hadir = scan.nextInt();

                            System.out.print("Masukkan jumlah tidak hadir: ");
                            tidakHadir = scan.nextInt();

                            scan.nextLine();

                            if (hadir + tidakHadir != jumlah) {
                                System.out.println(
                                    "Jumlah hadir + tidak hadir harus sama dengan jumlah hari kerja!"
                                );
                                System.out.println("Silakan input ulang.\n");
                            }

                        } while (hadir + tidakHadir != jumlah);
                        for (int i = 0; i < hadir; i++) {
                            karyawan.absen();
                        }
                        System.out.println("\nNama karyawan: " + karyawan.getnama());
                        System.out.println("ID karyawan: " + karyawan.getIdKaryawan());
                        System.out.println("Total gaji Anda: " + karyawan.hitungGaji());
                        karyawan.validasi();
                        
                } else {
                    System.out.println("Pilihan tidak valid!");
                }
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
                System.out.println("Input salah! Ulangi.");
                scan.nextLine(); 
                kategori = ""; 
            }    
        } while (!kategori.equals("1") && !kategori.equals("2"));
 
        scan.close();
    }
}
