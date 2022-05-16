class Solution {
    public int minDeletionSize(String[] strs) {
        int res = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            boolean flag = false;
            int c = 'a';
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) >= c) {
                    c = strs[j].charAt(i);
                } else {
                    flag = true;
                    break;
                }
            }
            if (flag) res++;
        }
        return res;
    }
}