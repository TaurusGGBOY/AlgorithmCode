class Solution {
  public int search(int[] nums, int target) {
    return binSearch(nums, 0, nums.length - 1, target);
  }

  int binSearch(int[] nums, int left, int right, int target) {
    if (left > right) return -1;
    int mid = (left + right) / 2;
    if (target == nums[mid]) return mid;
    if (target > nums[mid]) {
      return binSearch(nums, mid+1, right, target);
    } else {
      return binSearch(nums, left, mid-1, target);
    }
  }
}
