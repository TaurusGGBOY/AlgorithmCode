class Solution {
    public int[] decrypt(int[] code, int k) {
        int[] res = new int[code.length];
        if (k == 0) return res;
        for (int i = 0; i < code.length; i++) {
            for (int j = k; j < 0; j++) res[i] += code[(i + j + code.length) % code.length];
            for (int j = 0; j < k; j++) res[i] += code[(i + j + 1) % code.length];
        }
        return res;
    }
}