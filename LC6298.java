class Solution {
    // 000 011 101 111 or
    // 000 101 011 110 xor
    // 0000 1011 0111 1110 1101
    public boolean makeStringsEqual(String s, String target) {
        if(s.equals(target)) return true;
        int oneCount1 = 0;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            if (c1 == '1') {
                oneCount1++;
            }
        }

        int oneCount2 = 0;
        for (int i = 0; i < target.length(); i++) {
            char c1 = target.charAt(i);
            if (c1 == '1') {
                oneCount2++;
            }
        }

        if (oneCount2 == 0 && oneCount1 % 2 == 0) return false;
        if (oneCount2 == 0 && oneCount1 != 0) return false;
        if (oneCount1 == 0 && oneCount2 != 0) return false;
        if (oneCount1 == 0 && oneCount2 % 2 == 0) return false;
        return true;
    }
}