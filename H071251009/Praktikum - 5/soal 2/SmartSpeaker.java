public class SmartSpeaker extends PerangkatElektronik implements InteraksiInternet,KontrolSuara{

    public SmartSpeaker(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void ProsesPerintah(String Perintah) {
        if(Perintah.equals("NYALA")){
            System.out.println("Speaker menyala menggelegar");
        }
    }

    @Override
    public void hubungkanWIFI() {
       System.out.println("Mengirim data ke server");
    }

    @Override
    void cekFungsi() {
       System.out.println(merk+"berfungsi dengan baik");
    }
    
}
