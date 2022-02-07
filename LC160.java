public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;

        while(nodeA != nodeB && nodeA != null) nodeA =nodeA.next;
        if(nodeA == nodeB) return nodeA;
        nodeA = headA;
        nodeB = headB;

        while(nodeA != nodeB && nodeB != null) nodeB =nodeB.next;
        if(nodeA == nodeB) return nodeA;
        nodeA = headA;
        nodeB = headB;

        while (nodeA != nodeB) {
            if (nodeA == null) nodeA = headB;
            if (nodeB == null) nodeB = headA;
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }
}