class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        int halfLen = (intLength+1) / 2;
        long[] res = new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int q = queries[i];
            int maxLeft = (int) Math.pow(10, halfLen) - (int) Math.pow(10, halfLen - 1) - 1;
            int mid = q / maxLeft;
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            temp.append(q + (int) Math.pow(10, halfLen - 1) - 1);
            stringBuilder.append(temp);
            if (intLength != 2 * halfLen) {
                temp.deleteCharAt(temp.length() - 1);
            }
            stringBuilder.append(temp.reverse());
            if(stringBuilder.length() > intLength) res[i] = -1;
            else res[i] = Long.parseLong(stringBuilder.toString());
        }
        return res;
    }
}