public class ByteConverter {
    public static void main(String[] args) {
        printSize(1_500_000_000L);
    }

    static void printSize(long bytes) {
        long kb = bytes / 1024;
        long mb = kb / 1024;
        long gb = mb / 1024;
        long tb = gb / 1024;
        System.out.println(bytes + " bytes = " + kb + " KB = " + mb + " MB = " + gb + " GB = " + tb + " TB");
    }
}
