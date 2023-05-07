class Solution {
    public int countBinarySubstrings(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                int pos = 0;
                int pre = s.charAt(i);
                int next = s.charAt(i + 1);
                try {
                    while (pre == s.charAt(i - pos) && next == s.charAt(i + 1 + pos)) {
                        pos++;
                        sum++;
                    }
                } catch (Exception e) {
//                    System.out.println(sum);
                }
            }
        }
        return sum;
    }
}