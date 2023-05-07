class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int c : chalk) {
            sum += c;
        }
        long remind = k - sum * (k / sum);

        for (int i = 0; i < chalk.length; i++) {
            remind -= chalk[i];
            if (remind < 0) {
                return i;
            }
        }
        return -1;
    }
}