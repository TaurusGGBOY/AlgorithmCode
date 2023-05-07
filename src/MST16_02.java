import java.util.HashMap;
import java.util.Map;

class WordsFrequency {
    Map<String, Integer> map;

    public WordsFrequency(String[] book) {
        map = new HashMap<>();
        for (String string : book) {
            try {
                map.put(string, map.get(string) + 1);
            } catch (Exception e) {
                map.put(string, 1);
            }
        }
    }

    public int get(String word) {

        try {
            return map.get(word);
        } catch (Exception e) {
            return 0;
        }
    }
}

/**
 * Your WordsFrequency object will be instantiated and called as such:
 * WordsFrequency obj = new WordsFrequency(book);
 * int param_1 = obj.get(word);
 */