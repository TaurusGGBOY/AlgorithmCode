import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    stringBuilder.append("null,");
                } else {
                    stringBuilder.append(node.val);
                    stringBuilder.append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        if (stringBuilder.charAt(stringBuilder.length() - 1) == ',') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        if (data.equals("null")) {
            return null;
        }
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        for (; i < strs.length; i += 2) {
            TreeNode node = queue.poll();
            String l = strs[i];
            String r = strs[i + 1];
            if (!l.equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(l));
                node.left = leftNode;
                queue.offer(leftNode);
            }
            if (!r.equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(r));
                node.right = rightNode;
                queue.offer(rightNode);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));