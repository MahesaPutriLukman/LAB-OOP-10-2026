package Soal1;
class KaryawanTetap extends Karyawan{
    int gajiPokok = 100000000;
    int tunjanganMakan = 1000000;

    KaryawanTetap (String nama, String idKaryawan){
        super(nama, idKaryawan);
    }

    @Override
    int hitungGaji(){
        int totalGaji = gajiPokok + (tunjanganMakan*getjumlahKehadiran());
        return totalGaji;
    }
    double hitungGaji (double bonusKinerja){
        double totalGaji = hitungGaji() + bonusKinerja;
        return totalGaji;
    }     
}
