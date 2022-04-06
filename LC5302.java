import java.util.*;

class Encrypter {

    String[] values;
    char[] keys;
    Map<String, Integer> valueMap;
    String[] dictionary;
    Map<Character, Integer> keyMap;
    Map<String, Integer> counter;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        keyMap = new HashMap<>();
        valueMap = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            keyMap.put(keys[i], i);
        }
        for (int i = 0; i < values.length; i++) {
            valueMap.put(values[i], i);
        }
        this.keys = keys;
        this.values = values;
        this.dictionary = dictionary;
        counter = new HashMap<>();
        for (String s : dictionary) {
            counter.merge(encrypt(s), 1, Integer::sum);
        }
    }

    public String encrypt(String word1) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : word1.toCharArray()) {
            stringBuilder.append(values[keyMap.get(c)]);
        }
        return stringBuilder.toString();
    }

    public int decrypt(String word2) {
        return counter.getOrDefault(word2, 0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */