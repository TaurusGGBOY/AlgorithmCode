/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] listOfDepth(TreeNode tree) {
        Vector<ListNode> vector = new Vector();
        if (tree == null)
            return new ListNode[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);

        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = queue.poll();
            ListNode listNode = new ListNode(node.val);
            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);
            listNode.next = null;
            vector.add(listNode);
            for (int i = 0; i < size-1; i++) {
               node = queue.poll();
                ListNode newNode = new ListNode(node.val);
                newNode.next = null;
                listNode.next = newNode;
                listNode = newNode;
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        ListNode[] lists = new ListNode[vector.size()];
        for (int i = 0; i < vector.size(); i++) {
            lists[i] = vector.get(i);
        }
        return lists;
    }
}