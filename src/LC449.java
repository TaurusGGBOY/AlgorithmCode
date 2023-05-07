import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            stringBuilder.append(poll == null ? "null" : poll.val).append(" ");
            if (poll == null) continue;
            queue.offer(poll.left);
            queue.offer(poll.right);
        }
        return stringBuilder.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(" ");
        if(strs[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (strs[i].equals("null")) {
                poll.left = null;
            }else{
                poll.left = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(poll.left);
            }
            i++;
            if (strs[i].equals("null")) {
                poll.right = null;
            }else{
                poll.right = new TreeNode(Integer.parseInt(strs[i]));
                queue.offer(poll.right);
            }
            i++;
        }
        return root;
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;