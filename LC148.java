public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

// �鲢ʧ��

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        // �ҵ��е�
        // ���е㿪ʼ?
        ListNode quickNode = head;
        ListNode slowNode = head;
        while (quickNode.next != null) {
            slowNode = slowNode.next;
            quickNode = quickNode.next.next;
        }
        ListNode midNode = slowNode;

        ListNode current = head;
        while (current.next)
    }
}