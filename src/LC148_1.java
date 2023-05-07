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
// 2. 要一个不能交换值的写法
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode yummy = new ListNode(-1, head);
        quickSort(yummy, null);
        return yummy.next;
    }

    void quickSort(ListNode l, ListNode r) {
        if (l == r || l.next == r) return;
        ListNode m = partition(l, r);
        quickSort(l, m);
        quickSort(m, r);
    }

    // 左闭右开
    ListNode partition(ListNode l, ListNode r) {
        ListNode small = new ListNode(-1);
        ListNode smallHead = small;
        ListNode big = new ListNode(-1);
        ListNode bigHead = big;

        ListNode pointer = l.next;
        ListNode ran = pointer;
        ListNode pivot = pointer;
        while (ran != r) {
            if (new Random().nextInt(10) >= 5) pivot = ran;
            ran = ran.next;
        }
        while (pointer != r) {
            if (pivot == pointer) {
                pointer = pointer.next;
                continue;
            }
            if (pointer.val < pivot.val) {
                small.next = pointer;
                small = small.next;
            } else {
                big.next = pointer;
                big = big.next;
            }
            pointer = pointer.next;
        }
        big.next = r;
        small.next = pivot;
        pivot.next = bigHead.next;
        l.next = smallHead.next;
        return small.next;
    }


    void toString(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}
