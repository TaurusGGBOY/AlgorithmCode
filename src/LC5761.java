import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class FindSumPairs {

    Map<Integer, Integer> map1;
    Map<Integer, Integer> map2;
    int[] n1;
    int[] n2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        map1 = new TreeMap<>();
        map2 = new HashMap<>();
        for (int i : nums1) {
            map1.merge(i, 1, (oldval, newval) -> oldval + newval);
        }
        for (int i : nums2) {
            map2.merge(i, 1, (oldval, newval) -> oldval + newval);
        }
        n1 = nums1;
        n2 = nums2;
    }

    public void add(int index, int val) {
        map2.put(n2[index], map2.get(n2[index]) - 1);
        n2[index] += val;
        map2.merge(n2[index], 1, (oldval, newval) -> oldval + newval);
    }

    public int count(int tot) {
        int res = 0 ;
        Iterator<Map.Entry<Integer, Integer>> iterator = map1.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getKey() >= tot) {
                break;
            }
            res += next.getValue() * map2.getOrDefault(tot - next.getKey(), 0);
        }
        return res;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */