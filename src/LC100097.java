import java.util.*;

class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int num : nums) {
            counter.merge(num, 1, Integer::sum);
        }

        if (counter.size() == 1) {
            return 1;
        }

        int min = Integer.MAX_VALUE;
        int r = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            r = Math.max(entry.getValue(), r);
            min = Math.min(entry.getValue(), min);
        }

        if (r - min <= 1) {
            return counter.size();
        }

        int l = 1;
        int element = 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            System.out.println(l + " " + m + " " + r);

            boolean flag = true;
            for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
                int remind = entry.getValue() % m;
                int div = entry.getValue() / m;

                System.out.println("remind:" + remind + " " + div + " " + r);
                if (remind != 0 && (remind > div || remind != m - 1)) {
                    flag = false;
                    break;
                }
            }
            System.out.println("flag:" + flag);
            if (flag) {
                element = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        System.out.println("ele:" + element);
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int remind = entry.getValue() / (element + 1);
            int div = entry.getValue() / (element + 1);

            res += div;
            if (remind != 0) {
                ++res;
            }
        }
        System.out.println();
        return res;
    }
}