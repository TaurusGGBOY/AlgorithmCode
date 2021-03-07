class Solution {
    public boolean checkOnesSegment(String s) {
        int flag = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                flag = 1;
            } else {
                if (flag == 1)
                    return false;
            }
        }
        return true;
    }
}