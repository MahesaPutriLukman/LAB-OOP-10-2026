public abstract class PerangkatElektronik {

    private String merk;
    private int dayaListrik;

    public PerangkatElektronik(String merk, int dayaListrik) {

        if (merk == null || merk.trim().isEmpty()) {
            throw new IllegalArgumentException("Merk perangkat tidak boleh kosong.");
        }

        if (dayaListrik <= 0) {
            throw new IllegalArgumentException("Daya listrik harus lebih dari 0 Watt.");
        }
        this.merk = merk.trim();
        this.dayaListrik = dayaListrik;
    }


    public abstract void cekFungsi();

    public void infoPower() {
        System.out.println("Perangkat " + merk + " sedang menyedot daya sebesar " + dayaListrik + " Watt.");
    }

    public String getMerk() {
        return merk;
    }
}
