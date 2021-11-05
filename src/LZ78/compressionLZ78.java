package LZ78;
import java.util.*;
public class compressionLZ78 {
    private String statement;
    private final HashMap<Integer, String> dictionary = new HashMap<>();
    protected ArrayList<Character> chars = new ArrayList<Character>();
    protected ArrayList<Integer> positions = new ArrayList<Integer>();
    private  int key=1;

    public void setStatement(String statement) {
        this.statement = statement;
    }
    public String getStatement() {
        return statement;
    }
    public ArrayList<Integer> getPositions() {
        return positions;
    }
    public ArrayList<Character> getChars() {
        return chars;
    }
    public Integer getKey(Map<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
        public void compress() {
        int i = 0;
         while(i<statement.length()) {
            StringBuilder sub = new StringBuilder();
             boolean condition = false;
            int position = 0;
            for (int j = 0; j <=i; j++) {
                if(i<statement.length())
                    sub.append(statement.charAt(i));
                else{
                    chars.add(' ');
                    positions.add(position);
                    break;
                }
                if (dictionary.containsValue(String.valueOf(sub))) {
                    position =getKey(dictionary,String.valueOf(sub));
                } else {
                    dictionary.put(key, String.valueOf(sub));
                    key++;
                    chars.add(statement.charAt(i));
                    positions.add(position);
                    condition =true;
                }
                i++;
                if (condition)
                    break;
            }
        }
    }
    public void pintDictionary() {
        System.out.println("Dictionary");
        System.out.println("____________");
        System.out.println("|  0 | -- |");
        System.out.println("____________");
        for (Integer i : dictionary.keySet()) {
            System.out.println("| " + i + " | " + dictionary.get(i) + "  |");
            System.out.println("-----------");
        }
    }
    public void printTags(){
        for (int i = 0; i < chars.size(); i++) {
            System.out.println("tag" + (i + 1) + ":");
            System.out.print("< "+positions.get(i));
            System.out.println(", "+chars.get(i)+">");

        }

    }

}
