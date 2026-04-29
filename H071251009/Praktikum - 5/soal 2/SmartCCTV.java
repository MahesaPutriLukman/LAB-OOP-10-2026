class SmartCCTV extends PerangkatElektronik implements InteraksiInternet{

    public SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    public void hubungkanWIFI() {
       System.out.println("Mengirim data ke server ");
    }

    @Override
    void cekFungsi() {
      System.out.println(merk+"Berfungsi dengan baik dan benar (aman banget)");
    }
    
}
