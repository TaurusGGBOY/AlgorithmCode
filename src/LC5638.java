import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int eatenApples(int[] apples, int[] days) {
        // 存储的是第i天有多少个还在
        Map<Integer, Integer> map = new TreeMap<>();
        int res = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (i < days.length && apples[i] > 0) {
                int count = map.getOrDefault(days[i] + i, 0);
                count += apples[i];
                map.put(days[i] + i, count);
            }

//            System.out.println(map.toString());
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next();
                if (next.getKey() > i) {
                    int remind = next.getValue() - 1;
                    if (remind <= 0)
                        iterator.remove();
                    else
                        next.setValue(remind);
                    res++;
                    break;
                } else {
                    iterator.remove();
                }
            }
            if (map.isEmpty() && i >= days.length) {
                break;
            }
//            System.out.println(res);
        }

        return res;
    }
}