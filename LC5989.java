import java.util.TreeMap;

class Solution {
    public int countElements(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        if (map.size() <= 2) {
            return 0;
        }
        return nums.length - map.firstEntry().getValue() - map.lastEntry().getValue();
    }
}