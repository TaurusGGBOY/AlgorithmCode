import java.util.Vector;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");
        for(int i = 0;i<strs.length;i++)
        {
            String str = strs[i];
            if(str.startsWith(searchWord))
                return i+1;
        }
        return -1;
    }
}