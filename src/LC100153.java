import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Set<Integer> set = new HashSet<>();

        for (int coin : coins) {
            Set<Integer> newSet = new HashSet<>();
            for (int num : set) {
                if (num + coin <= target) {
                    newSet.add(num + coin);
                }
            }

            set.addAll(newSet);

            if (coin <= target) {
                set.add(coin);
            }
        }

        System.out.println(set.size());

        return (target - set.size()) / set.size();
    }
}