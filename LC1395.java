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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums,0,nums.length-1);
    }

    TreeNode dfs(int[] nums, int start, int end)
    {
//        System.out.println("jinlaile");
        if(start>end)
            return null;
        int max=Integer.MIN_VALUE;
        int maxPos=start;
        for (int i = start; i <= end; i++) {
            if(nums[i]>max)
            {
                max=nums[i];
                maxPos = i;
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = dfs(nums,start,maxPos-1);
        node.right = dfs(nums,maxPos+1,end);
//        System.out.println(node.val);
        return node;
    }
}