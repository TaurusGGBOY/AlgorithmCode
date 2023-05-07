class Solution {
    public int minimumPartition(String s, int k) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int res = 0;
        for (char c : chars) {
            int num = c - '0';
            long buffer = stringBuilder.length() == 0 ? 0 : Long.parseLong(stringBuilder.toString());
            if (buffer > k) return -1;
            long next = buffer * 10 + num;
            if (next <= k) {
                stringBuilder.append(c);
                continue;
            }
            stringBuilder.setLength(0);
            stringBuilder.append(c);
            res++;
        }
        if (stringBuilder.length() > 0) {
            long num = Long.parseLong(stringBuilder.toString());
            if (num > k) return -1;
            res++;
        }
        return res;
    }
}