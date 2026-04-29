public class Main {
    public static void main(String[] args) {
        KaryawanTetap baco = new KaryawanTetap("Baco", "123", 1000000, 30000);
        KaryawanKontrak gamal = new KaryawanKontrak("Gamal", "456", 100000);
       
        
        for (int i= 0;i<=10;i++){
            baco.absen();
        }
        baco.hitungGaji(1000000);
        
        System.out.println("Nama: "+ baco.getNama());
        System.out.println("Id karyawan: "+ baco.getIdKaryawan());
        System.out.println("jumlahKehadiran: "+baco.getJumlahKehadiran());
        System.out.println("Gaji: "+baco.hitungGaji());
        System.out.println("Gaji dan bonus: "+ baco.hitungGaji(1000000));
  
        for (int i = 0 ; i<= 21;i++){
            gamal.absen();
        }
        
        gamal.hitungGaji();

        System.out.println("Nama: "+ gamal.getNama());
        System.out.println("Id karyawan: "+ gamal.getIdKaryawan());
        System.out.println("Jumlah kehadiran: "+ gamal.getJumlahKehadiran());
        System.out.println("Gaji: "+ gamal.hitungGaji());
    }
}
