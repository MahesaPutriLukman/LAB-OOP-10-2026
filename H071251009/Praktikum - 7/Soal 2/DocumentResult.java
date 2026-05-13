public class DocumentResult {
     String documentName;
    String threadName;
    int wordCount;
    long duration;

    public DocumentResult(String documentName,
                          String threadName,
                          int wordCount,
                          long duration) {
        this.documentName = documentName;
        this.threadName = threadName;
        this.wordCount = wordCount;
        this.duration = duration;
    }
}
