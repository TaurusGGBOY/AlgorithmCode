class Solution {

    public int findLUSlength(String[] strs) {
        int max = -1;

        for (int i = 0; i < strs.length; i++) {
            boolean flag = true;
            for (int j = 0; j < strs.length; j++) {
                if (i == j) continue;
                if (isSub(strs[i], strs[j])) flag = false;
            }
            if (flag) max = Math.max(strs[i].length(), max);
        }
        return max;
    }

    boolean isSub(String s1, String s2) {
       int l =0, r=0;
        while (l < s1.length() && r < s2.length()) {
            if(s1.charAt(l)==s2.charAt(r)) l++;
            r++;
        }
        return l == s1.length();
    }


}