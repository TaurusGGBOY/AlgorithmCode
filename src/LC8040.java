class Solution {
    public int minimumOperations(String num) {
        int[] counter = new int[10];
        for (int i = num.length() - 1; i >= 0; i--) {
            int len = num.length() - i;
            char c = num.charAt(i);
            counter[c - '0']++;

            if (counter[0] == 2) {
                return len - 2;
            } else if (c == '2' && counter[5] > 0) {
                return len - 2;
            } else if (c == '5' && counter[0] > 0) {
                return len - 2;
            } else if (c == '7' && counter[5] > 0) {
                return len - 2;
            }
        }
        if (counter[0] > 0) {
            return num.length() - 1;
        }
        return num.length();
    }
}