import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode yummy;

    public Solution(ListNode head) {
        yummy = head;
    }

    public int getRandom() {
        ListNode temp = yummy;
        int i = 0, res = 0;
        while (temp != null){
            if(new Random().nextInt(++i) == 0) res = temp.val;
            temp = temp.next;
        }
        return res;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */