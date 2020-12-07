// TODO：失败

import java.util.*;

class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        int[] count = new int[16];
        int each = nums.length / k;
        if (each == 1)
            return 0;
        SortedMap<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                List<Integer> defaultList = map.getOrDefault(count[i], new ArrayList<>());
                defaultList.add(i);
                map.put(count[i], defaultList);
            }
        }
        System.out.println(map.toString());
        int sum = 0;
        int time = nums.length / k;
        for (int i = 0; i < time; i++) {
            List<Integer> firstList = map.get(map.firstKey());
            if (firstList.size() >= each) {
                if (firstList.size() > each) {

                }
            } else {

            }
        }
        return sum;
    }

    int getNearest() {

    }

    int getSum(List<Integer> list, int each) {

    }
}
//[1,1,2,2,3,3,6,8]
//[1,2,3,3,6,8]
//[1,3,6,8]
//[1,3,6,8]
