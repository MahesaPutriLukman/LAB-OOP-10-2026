package soal2;

public class DocumentResult {

    // menyimpan nama dokumen yang diproses
    String documentName;

    // menyimpan nama thread yang memproses dokumen
    String threadName;

    // menyimpan jumlah kata hasil proses
    int wordCount;

    // menyimpan lama waktu proses dalam milidetik
    long duration;

    // constructor untuk mengisi data hasil proses dokumen
    public DocumentResult(String documentName,
                          String threadName,
                          int wordCount,
                          long duration) {

        // mengisi nama dokumen
        this.documentName = documentName;

        // mengisi nama thread
        this.threadName = threadName;

        // mengisi jumlah kata
        this.wordCount = wordCount;

        // mengisi durasi proses
        this.duration = duration;
    }
}