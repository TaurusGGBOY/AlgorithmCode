class Solution {
    public int maxDistance(int[] colors) {
        int max = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = colors.length - 1; j >= i; j--) {
                int len = j - i;
                if (colors[j] != colors[i]) {
                    max = Math.max(len, max);
                }
            }
        }
        return max;
    }
}