/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = getNode(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode getNode(int[] nums, int start, int end)
    {
        if(start>end)
            return null;

        int mid = (start + end) / 2;
        TreeNode root =  new TreeNode(nums[mid]);
        root.left = getNode(nums, start, mid - 1);
        root.right = getNode(nums, mid + 1, end);
        return root;
    }
}