import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public int[] nodesBetweenCriticalPoints(ListNode head) {
    List<Integer> list = new ArrayList<>();
    while(head!=null){
      list.add(head.val);
      head = head.next;
    }
    List<Integer> res = new ArrayList<>();
    for (int i = 1; i < list.size()-1; i++) {
      if (list.get(i - 1) < list.get(i) && list.get(i + 1) < list.get(i)) {
        res.add(i);
      }else if(list.get(i - 1) > list.get(i) && list.get(i + 1) > list.get(i)){
        res.add(i);
      }
    }
//    System.out.println(list.toString());
//    System.out.println(res.toString());
    if (res.size() < 2) {
      return new int[]{-1,-1};
    }
    int max = res.get(res.size() - 1) - res.get(0);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < res.size()-1; i++) {
      min = Math.min(min, res.get(i + 1) - res.get(i));
    }
    return new int[]{min, max};
  }
}