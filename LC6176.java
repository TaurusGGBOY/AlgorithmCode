class Solution {
    public int mostFrequentEven(int[] nums) {
        int[] count = new int[100001];
        boolean flag = false;
        for (int num : nums) {
            if (num % 2 == 1) continue;
            flag = true;
            count[num]++;
        }
        if (!flag) return -1;
        int max = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > count[max]) {
                max = i;
            }
        }
        return max;
    }
}