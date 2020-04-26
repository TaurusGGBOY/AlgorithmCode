class Solution {
    public int minArray(int[] numbers) {
        int min =numbers[0];
        for(int num:numbers)
            min = Math.min(num, min);
        return min;
    }
}