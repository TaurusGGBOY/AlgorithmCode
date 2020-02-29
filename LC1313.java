import java.util.Vector;

class Solution {
    public int[] decompressRLElist(int[] nums) {
        Vector<Integer> vector = new Vector<Integer>();
        for (int i = 0; i < nums.length / 2; i++) {
            for (int j = 0; j < nums[2 * i]; j++) {
                vector.add(nums[2 * i + 1]);
            }
        }
        int[] temp = new int[vector.size()];
        for (int i = 0; i < vector.size(); i++)
            temp[i] = vector.get(i);

        return temp;
    }
}