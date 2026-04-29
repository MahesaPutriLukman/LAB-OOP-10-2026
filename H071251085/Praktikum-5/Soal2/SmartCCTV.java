package Soal2;

class SmartCCTV extends PerangkatElektronik implements InteraksiInternet {

    SmartCCTV(String merk, int dayaListrik) {
        super(merk, dayaListrik);
    }

    @Override
    String cekFungsi() {
        return "CCTV digunakan untuk memantau area.";
    }

    @Override
    public void hubungkanWiFi() {
        System.out.println("mengirim data ke server...");
    }
}
