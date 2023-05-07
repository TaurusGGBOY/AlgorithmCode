// 失败
import java.util.*;

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k<bloomDay.length)
            return -1;
        int[] sortedBloomDay = new int[bloomDay.length];
        Vector<Integer> vector = new Vector<>();
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : bloomDay) {
            counts.merge(num, 1, (oldval, newval) -> oldval + newval);
            vector.add(num);
        }
        vector.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        Map<Integer, Integer> totalFlows = new HashMap<>();
        totalFlows.put(vector.get(0), counts.get(vector.get(0)));
        int start = vector.size()-1;
        int end =0;
        for (int i = 1; i < vector.size(); i++) {
            int count = totalFlows.get(i - 1) + counts.get(i);
            totalFlows.put(vector.get(i), count);
            if(count<bloomDay.length-m*k)
            {
                start = Math.min(start, i);

            }
        }
        System.arraycopy(bloomDay, 0, sortedBloomDay, 0, bloomDay.length);
        Arrays.sort(sortedBloomDay);

    }
}