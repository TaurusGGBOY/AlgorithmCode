import java.util.*;

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        if (arr.length == 0) return true;
        int[] vis = new int[arr.length];
        int l = 0, r = 1;
        Arrays.sort(arr);
        int remind = 0;
        while (l < arr.length && r < arr.length) {
            while (l < arr.length && vis[l] == 1) l++;
            while (r < arr.length && ((arr[l] > 0 && arr[r] != 2 * arr[l]) || (arr[l] <= 0 && 2 * arr[r] != arr[l]))) {
                r++;
                remind++;
            }
            if (r == arr.length) return false;
            vis[r] = 1;
            r += remind == 0 ? 2 : 1;
            if (remind == 0) remind = 1;
            l++;
            remind--;
        }
        return remind == 0;
    }
}