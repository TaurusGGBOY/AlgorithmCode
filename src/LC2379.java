import java.util.Arrays;

class Solution {
    public int minimumRecolors(String blocks, int k) {
        int[] left = new int[blocks.length()];
        int[] right = new int[blocks.length()];

        if (blocks.charAt(0) == 'W') left[0] = 1;
        if (blocks.charAt(blocks.length() - 1) == 'W') right[blocks.length() - 1] = 1;

        for (int i = 1; i < blocks.length(); i++) {
            left[i] = left[i - 1] + (blocks.charAt(i) == 'W' ? 1 : 0);
        }


        for (int i = blocks.length() - 2; i >= 0; i--) {
            right[i] = right[i + 1] + (blocks.charAt(i) == 'W' ? 1 : 0);
        }

        int res = Math.min(left[k - 1], right[blocks.length() - k]);

        for (int i = 1; i + k < blocks.length(); i++) {
            // i ~ i+k-1
            res = Math.min(res, right[0] - left[i - 1] - right[i + k]);
        }

        return res;
    }
}