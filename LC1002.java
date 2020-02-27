import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] A) {
        int[] last = new int[26];
        int[] temp = new int[26];
        for (int i = 0; i < 26; i++) {
            last[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < A.length; i++) {
            temp = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                temp[A[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                last[j] = Math.min(last[j], temp[j]);
            }
        }
        //System.out.println(last.toString());
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if(last[i]==Integer.MAX_VALUE)
                continue;
            for (int j = 0; j < last[i]; j++) {
                list.add(String.valueOf((char) (i + 'a')));
            }
        }
        return list;
    }
}