class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = new ListNode(0);
        prev.next = head;
        quickSort(prev, null);
        return prev.next;
    }

    boolean isOrdered(ListNode l, ListNode r) {
        ListNode node = l.next;
        int temp = node.val;
        while (node != r) {
            if (temp > node.val) {
                return false;
            }
            temp = node.val;
            node = node.next;
        }
        return true;
    }

    public void quickSort(ListNode l, ListNode r) {
        if (l.next == r || l.next.next == r)
            return;
        ListNode m = partition(l, r);
        if (isOrdered(l, r)) {
            return;
        }
        quickSort(l, m);
        quickSort(m, r);
    }

    public ListNode partition(ListNode l, ListNode r) {
        ListNode p = l.next.next;
        ListNode lessHead = new ListNode(0);
        ListNode lessPointer = lessHead;
        ListNode moreHead = new ListNode(0);
        ListNode morePointer = moreHead;
        ListNode m = l.next;
        while (p != r) {
            if (p.val <= m.val) {
                lessPointer.next = p;
                lessPointer = lessPointer.next;
            } else {
                morePointer.next = p;
                morePointer = morePointer.next;
            }
            p = p.next;
        }
        if (lessHead.next != null) {
            l.next = lessHead.next;
            lessPointer.next = m;
        } else {
            l.next = m;
        }
        if (moreHead.next != null) {
            m.next = moreHead.next;
            morePointer.next = r;
        } else {
            m.next = r;
        }
        return m;
    }
}