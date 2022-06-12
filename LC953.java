import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alpha = new int[26];
        for (int i = 0; i < order.length(); i++) {
            alpha[order.charAt(i)-'a'] = i + 'a';
        }
        List<String> temp1 = new ArrayList<>();
        for (String word : words) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                stringBuilder.append((char) (alpha[word.charAt(i) - 'a']));
            }
            temp1.add(stringBuilder.toString());
        }
        List<String> temp2 = new ArrayList<>(temp1);
        Collections.sort(temp1);
//        System.out.println(temp1.toString());
//        System.out.println(temp2.toString());
//        System.out.println();
        for (int i = 0; i < temp1.size(); i++) {
            if (!temp1.get(i).equals(temp2.get(i))) return false;
        }
        return true;
    }
}