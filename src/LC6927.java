import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int[] left = new int[nums.size()];
        int[] right = new int[nums.size()];

        Map<Integer, Integer> counter = new HashMap<>();
        int max = nums.get(0);
        for (int i = 0; i < nums.size(); i++) {
            int count = counter.merge(nums.get(i), 1, Integer::sum);
            if (count > counter.get(max)) {
                max = nums.get(i);
            }

            if (counter.get(max) * 2 > i + 1) {
                left[i] = max;
            } else {
                left[i] = -1;
            }
        }

        counter.clear();
        max = nums.get(nums.size() - 1);

        for (int i = nums.size() - 1; i >= 0; i--) {
            int count = counter.merge(nums.get(i), 1, Integer::sum);
            if (count > counter.get(max)) {
                max = nums.get(i);
            }

            if (counter.get(max) * 2 > nums.size() - i) {
                right[i] = max;
            } else {
                right[i] = -1;
            }
        }

        for (int i = 0; i < left.length - 1; i++) {
            if (left[i] == right[i + 1] && left[i] != -1) {
                return i;
            }
        }

        return -1;
    }
}