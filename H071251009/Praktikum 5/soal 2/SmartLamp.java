class SmartLamp extends PerangkatElektronik implements KontrolSuara{
    public SmartLamp(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void ProsesPerintah(String Perintah) {
        if (Perintah.equals("NYALA")){
            System.out.println("Lampu Berpijar");
        }
    }

    @Override
    void cekFungsi() {
        System.out.println(merk+"berfungsi dengan baik dan benar tanpa eror");
    }
    
}
