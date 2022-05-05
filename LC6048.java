import java.util.*;

class Solution {
    public int minimumCardPickup(int[] cards) {
        int min = cards.length;
        int l = 0, r = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        map.put(1, new HashSet<>());
        map.put(2, new HashSet<>());
        int flag = 0;

        while (l < cards.length && r < cards.length) {
            while (r < cards.length) {
                if (map.get(1).contains(cards[r])) {
                    map.get(1).remove(cards[r]);
                    map.get(2).add(cards[r]);
                    r++;
                    flag = 1;
                    break;
                }
                map.get(1).add(cards[r]);
                r++;
            }
            while (l < cards.length) {
                if (map.get(2).contains(cards[l])) {
                    map.get(2).remove(cards[l]);
                    map.get(1).add(cards[l]);
                    l++;
                    min = Math.min(r + 1 - l, min);
                    break;
                }
                map.get(1).remove(cards[l]);
                l++;
            }
        }
        return flag == 0 ? -1 : min;
    }
}