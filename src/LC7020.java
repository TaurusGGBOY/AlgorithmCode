class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for (int i = low; i <= high; ++i) {
            String s = Integer.toString(i);

            if (s.length() % 2 == 1) {
                continue;
            }

            int left = 0;
            int right = 0;
            for (int j = 0; j < s.length() / 2; j++) {
                left += s.charAt(j) - '0';
                right += s.charAt(s.length() - j - 1) - '0';
            }
            if (left == right) {
                res++;
            }
        }
        return res;
    }
}