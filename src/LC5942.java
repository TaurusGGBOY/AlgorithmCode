import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] temp = new int[10];
        for (int digit : digits) {
            temp[digit]++;
        }
        Set<Integer> set = new HashSet<>();
        int[] ou = new int[]{0, 2, 4, 6, 8};
        for (int i = 1; i < temp.length; i++) {
            if (temp[i] <= 0) {
                continue;
            }
            temp[i]--;
            for (int j = 0; j < temp.length; j++) {
                if (temp[j] <= 0) {
                    continue;
                }
                temp[j]--;
                for (int k = 0; k < ou.length; k++) {
                    if (temp[ou[k]] <= 0) {
                        continue;
                    }
                    set.add(ou[k] + j * 10 + i * 100);
                }
                temp[j]++;
            }
            temp[i]++;
        }
        List<Integer> list = new ArrayList<>(set);
        list.sort(null);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}