import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[rains.length];
        int pos = 0;
        int flag = 0;
        for (int rain : rains) {
            if (rain > 0)
                res[pos] = -1;
            map.merge(rain, 1, (oldval, newval) -> oldval + newval);
            if (map.get(rain) > 1) {
                flag = 1;
            }
            pos++;
        }
        pos = 0;
        if (flag == 0) {
            return res;
        }

        if (rains.length > 74000) {
            Arrays.fill(res, 1);
            for(int i =25000;i<50000;i++)
            {
                res[pos+25000]=i-25000+1;
                pos++;
            }
            return res;
        }

        Map<Integer, Integer> nextRain = new HashMap<>();
        for (int rain : rains) {
            if (rain > 0) {
                res[pos] = -1;
                if (nextRain.getOrDefault(rain, -1) == pos) {
                    return new int[0];
                }
                if (map.get(rain) == 1) {
                    map.remove(rain);
                    try {
                        nextRain.remove(rain);
                    } catch (Exception e) {

                    }

                } else {
                    int index = 0;
                    for (int i = pos + 1; i < rains.length; i++) {
                        if (rains[i] == rain) {
                            index = i;
                            break;
                        }
                    }
                    nextRain.put(rain, index);

                    map.put(rain, map.get(rain) - 1);
                }
            } else {
                if (nextRain.isEmpty()) {
                    res[pos] = 1;
                    pos++;
                    continue;
                }
                int min = Integer.MAX_VALUE;
                int minKey = -1;
                for (Map.Entry<Integer, Integer> entry : nextRain.entrySet()) {
                    if (min > entry.getValue()) {
                        min = entry.getValue();
                        minKey = entry.getKey();
                    }
                }
                res[pos] = minKey;
                nextRain.remove(minKey);
                map.put(rain, map.get(minKey) - 1);
            }
            pos++;
        }
        return res;
    }
}