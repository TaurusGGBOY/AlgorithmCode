class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int temp = 0;
        int sum = 0;
        for (int i = 0; i < X; i++) {
            temp += customers[i] * grumpy[i];
            sum += customers[i] * (grumpy[i] ^ 1);
        }
        int max = temp;
        for (int i = X; i < customers.length; i++) {
            temp -= customers[i - X] * grumpy[i - X];
            temp += customers[i] * grumpy[i];
            max = Math.max(temp, max);
            sum += customers[i] * (grumpy[i] ^ 1);
        }
        return sum + max;
    }
}