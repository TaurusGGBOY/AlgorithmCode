import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String arrangeWords(String text) {
        text = text.toLowerCase();
        String[] strs = text.split(" ");
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        String first = (char)(strs[0].charAt(0)+'A'-'a')+strs[0].substring(1);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(first);
        for(int i=1;i<strs.length;i++)
        {
            stringBuilder.append(" ");
            stringBuilder.append(strs[i]);
        }
        return stringBuilder.toString();
    }
}