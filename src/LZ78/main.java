package LZ78;

public class main {
    public static void main(String[] args) {
        compressionLZ78 obj = new compressionLZ78();
        obj.setStatement("ABAABABBAABAABAABABBBBBBBB");
        obj.compress();
        obj.pintDictionary();
        obj.printTags();
        deCompressionLZ78 obj1 = new deCompressionLZ78(obj.getPositions(),obj.getChars());
        obj1.deCompression();
        obj1.printStatement();


    }
}
