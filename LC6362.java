import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map1 = new TreeMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i][0], nums1[i][1]);
        }
        for (int[] num : nums2) {
            if(!map1.containsKey(num[0])){
                map1.put(num[0], num[1]);
            }else{
                map1.put(num[0], num[1] + map1.get(num[0]));
            }

        }
        int[][] res = new int[map1.size()][2];
        Iterator<Map.Entry<Integer, Integer>> iterator = map1.entrySet().iterator();
        for (int i = 0; i < res.length; i++) {
            Map.Entry<Integer, Integer> next = iterator.next();
            res[i][0] = next.getKey();
            res[i][1] = next.getValue();
        }
        return res;
    }
}