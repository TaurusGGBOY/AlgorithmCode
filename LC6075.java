import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < capacity.length; i++) {
            list.add(new int[]{capacity[i], rocks[i]});
        }
        Collections.sort(list, (o1,o2)->{
            return o1[0] - o1[1] - (o2[0] - o2[1]);
        });
        int count = 0;
        for (int[] ints : list) {
            if(ints[0] !=ints[1]){
                int dis = ints[0] - ints[1];
                ints[1] += Math.min(dis, additionalRocks);
                additionalRocks -= Math.min(dis, additionalRocks);
            }
            if(ints[0]==ints[1]) count++;
        }

        return count;
    }
}