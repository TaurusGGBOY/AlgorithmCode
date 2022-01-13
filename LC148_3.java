class Solution {
    public ListNode sortList(ListNode head) {
        return sort(head, null);
    }

    ListNode sort(ListNode head, ListNode tail) {
        if (head == tail) return head;
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode list1 = sort(head, slow);
        ListNode list2 = sort(slow, tail);
        return merge(list1, list2);
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode yummy = new ListNode(-1);
        ListNode head = yummy;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                head.next = list2;
                break;
            } else if (list2 == null) {
                head.next = list1;
                break;
            }
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        return yummy.next;
    }
}