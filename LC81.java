import java.util.Arrays;

class Solution {
    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        return Arrays.binarySearch(nums, target)>=0;
    }

}