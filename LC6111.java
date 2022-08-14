import java.util.Arrays;

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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int l = 0, r = 0;
        int[][] res = new int[m][n];
        for (int i = 0; i < res.length; i++) {
            Arrays.fill(res[i], -1);
        }
        int[][] direct = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;
        int[][] vis = new int[m][n];
        while (head != null) {
            res[l][r] = head.val;
            vis[l][r] = 1;
            head = head.next;


            l += direct[d][0];
            r += direct[d][1];
            if (l >= 0 && r >= 0 && l < m && r < n && vis[l][r] == 0) {
                continue;
            }
            l -= direct[d][0];
            r -= direct[d][1];

            // turn
            d = (d + 1) % direct.length;

            l += direct[d][0];
            r += direct[d][1];
            if (l >= 0 && r >= 0 && l < m && r < n && vis[l][r] == 0) {
                continue;
            }

            break;
        }
        return res;
    }
}