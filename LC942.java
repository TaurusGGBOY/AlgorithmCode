class Solution {
    public int[] diStringMatch(String s) {
        int l = 0, r = s.length();
        int[] res = new int[s.length()+1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I') res[i] = l++;
            else res[i] = r--;
        }
        res[res.length - 1] = l;
        return res;
    }
}