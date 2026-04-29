package Soal1;
class KaryawanKontrak extends Karyawan {
    int upahPerHari = 5000000;

    KaryawanKontrak (String nama, String idKaryawan){
        super(nama, idKaryawan);
    }

    int hitungGaji(){
        int totalGaji = upahPerHari * getjumlahKehadiran();
        return totalGaji;
    }

    void validasi(){
        int totalGajiSekarang = hitungGaji();

        if (getjumlahKehadiran()>20){
            totalGajiSekarang += 500000;
            System.out.println("\nKehadiran Anda sebanyak " + getjumlahKehadiran() + " jadi Anda mendapatkan bonus\nTotal gaji Anda " + totalGajiSekarang);
        } else {
            System.out.println("\nKehadiran Anda sebanyak " + getjumlahKehadiran() + " jadi Anda tidak mendapatkan bonus\nTotal gaji Anda sama saja :)");
        }
    }
}
