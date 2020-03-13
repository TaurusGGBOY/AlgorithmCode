import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if ((S.charAt(i) >= 'a' && S.charAt(i) <= 'z') || (S.charAt(i) >= 'A' && S.charAt(i) <= 'Z')) {
                count++;
            }
        }

        for (int i = 0; i < Math.pow(2, count); i++) {
            String str=Integer.toBinaryString(i);
            int len = str.length();
            for (int j = 0; j < count - len; j++) {
                str="0"+str;
            }

            StringBuilder change = new StringBuilder(S);
            int temp=0;
            for (int j = 0; j < S.length(); j++) {
                if ((S.charAt(j) >= 'a' && S.charAt(j) <= 'z') || (S.charAt(j) >= 'A' && S.charAt(j) <= 'Z')) {
                    if (str.charAt(temp++) == '1') {
                        if ((S.charAt(j) >= 'a' && S.charAt(j) <= 'z')) {
                            change.setCharAt(j, (char) ('A' + S.charAt(j) - 'a'));
                        } else {
                            change.setCharAt(j, (char) ('a' + S.charAt(j) - 'A'));
                        }
                    }
                }
            }
            list.add(change.toString());

        }
        return list;
    }
}