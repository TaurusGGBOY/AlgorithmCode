class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int left =0;
        for (int i = 0; i < s.length(); i++) {
            if (left == 1 && s.charAt(i)==')') {
                left = 0;
                continue;
            }
            if (left == 0 && s.charAt(i) == '(') {
                left = 1;
                continue;
            }
            if(s.charAt(i) =='(') left++;
            else left--;
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}