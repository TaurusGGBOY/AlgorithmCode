class Solution {
    public int countLargestGroup(int n) {
        int[] sums = new int[100];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            int sum = 0;
            for (int j = 0; j < str.length(); j++) {
                sum += str.charAt(j) - '0';
            }
            sums[sum % 100]++;
        }
        int count = 0;
        for (int sum : sums) {
            if (max == sum) {
                count++;
            } else if (max < sum) {
                max = sum;
                count = 1;

            }


        }
        return count;
    }
}