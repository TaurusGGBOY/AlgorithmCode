class Solution {
    public int countTestedDevices(int[] batteryPercentages) {
        int res = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i] > 0) {
                ++res;
                for (int j = i + 1; j <= batteryPercentages.length - 1; ++j) {
                    batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
                }
            }
        }
        return res;
    }
}