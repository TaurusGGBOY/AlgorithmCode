// TODO 失败
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode prev = new ListNode(-1, head);
        int len = 0;
        while (prev.next != null) {
            prev = prev.next;
            len++;
        }
        prev.next = head;

        int shortLen = len / k;
        int longLen = shortLen + 1;

        int longCount = len - shortLen * k;
        int shortCount = longLen * k - len;

        ListNode[] ans = new ListNode[k];
        int index = 0;
        ListNode temp;
        for (int i = 0; i < longCount / longLen; i++) {
            ans[index] = prev.next;
            for (int j = 0; j < longLen; j++) {
                prev = prev.next;
            }
            temp = prev.next;
            prev.next = null;
            prev = temp;
        }
        if (shortLen == 0) {
            return ans;
        }
        for (int i = longCount / longLen; i < len / shortLen; i++) {
            ans[index] = prev.next;
            for (int j = 0; j < shortLen; j++) {
                prev = prev.next;
            }
            temp = prev.next;
            prev.next = null;
            prev = temp;
        }
        return ans;
    }
}