// 有点意思
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = (high + low) / 2;
        while (low < high) {
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if(nums[mid] > nums[high]){
                low = mid + 1;
            }else{
                high--;
            }
            mid = (high + low) / 2;
        }
        return nums[low];
    }
}