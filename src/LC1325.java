class Solution {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return root;
        remove(root, target);
        if(root.val==target&&root.left==null&&root.right==null)
            return null;
        return root;
    }

    public void remove(TreeNode root, int target) {
        if (root == null)
            return;
//        System.out.println(root.val);
        if (root.left != null && root.left.val == target && root.left.left == null && root.left.right == null) {
            root.left = null;
        }
        if (root.right != null && root.right.val == target && root.right.left == null && root.right.right == null) {
            root.right = null;
        }
        remove(root.left, target);
        remove(root.right, target);
        if (root.left != null && root.left.val == target && root.left.left == null && root.left.right == null) {
            root.left = null;
        }
        if (root.right != null && root.right.val == target && root.right.left == null && root.right.right == null) {
            root.right = null;
        }
    }

}