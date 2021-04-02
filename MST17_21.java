class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int res = 0;
        while (left <= right) {
            // 如果当前节点小于右边最大 那么当前节点就可以和左边最大接到水
            if (height[left] < rightMax) {
                res += Math.max(0, leftMax-height[left]);
                leftMax = Math.max(height[left], leftMax);
                left++;
            } else {
                res += Math.max(0, rightMax-height[right]);
                rightMax = Math.max(height[right], rightMax);
                right--;
            }
        }
        return res;
    }
}