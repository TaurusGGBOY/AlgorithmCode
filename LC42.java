class Solution {
    public int trap(int[] h) {
        int res = 0, l = 0, r = h.length - 1, lm = 0, rm = 0;
        while (l < r) {
            lm = Math.max(lm, h[l]);
            rm = Math.max(rm, h[r]);
            if (lm < rm) res += lm - h[l++];
            else res += rm - h[r--];
        }
        return res;
    }
}