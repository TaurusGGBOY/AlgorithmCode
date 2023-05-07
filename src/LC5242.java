import java.util.Arrays;

class Solution {
    public String greatestLetter(String s) {
        int[] alpha = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            alpha[c - 0] = 1;
        }
        String res  ="";
        char c = 'A';
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.charAt(i));
            if (alpha[s.charAt(i) - 0] == 1 && (alpha[s.charAt(i) + 'A' - 'a'] == 1 || alpha[s.charAt(i) - ('A' - 'a')] == 1)){
                if(res == "" || ((int)Character.toUpperCase(s.charAt(i)) > c)) {
                    res =  Character.toUpperCase(s.charAt(i)) + "";
                    c = Character.toUpperCase(s.charAt(i));
                }
            }
        }
        return res;
    }
}