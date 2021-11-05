package LZ78;

import java.util.*;

public class deCompressionLZ78 {
    protected ArrayList<Character> chars = new ArrayList<Character>();
    protected ArrayList<Integer> positions = new ArrayList<Integer>();
    protected StringBuilder sub = new StringBuilder();
    protected HashMap<Integer, String> dec = new HashMap<Integer, String>();
    protected int key = 1;

    deCompressionLZ78(ArrayList<Integer> positions, ArrayList<Character> chars) {
        this.chars = chars;
        this.positions = positions;
    }

    public void deCompression() {
        int i = 0;
        while (i < chars.size()) {
            StringBuilder dummy = new StringBuilder();
            if (positions.get(i) == 0) {
                sub.append(chars.get(i));
                dec.put(key, String.valueOf(chars.get(i)));
            } else {
                String statement = dec.get(positions.get(i));
                dummy.append(statement);
                dummy.append(chars.get(i));
                sub.append(dummy);
                dec.put(key, String.valueOf(dummy));
            }
            key++;
            i++;
        }
    }

    public void printStatement() {
        System.out.println(sub);
    }
}
