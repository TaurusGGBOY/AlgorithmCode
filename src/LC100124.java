import java.util.*;

class Solution {
    public int maximumStrongPairXor(int[] nums) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        Arrays.sort(nums);

        int l = 0;
        int r = 0;
        int totalBit = 21;
        int res = 0;

        for (int i = 0; i < totalBit; i++) {
            int offset = 1 << i;
            map.put(offset, new HashSet<>());
        }

        while (l < nums.length) {
            while (r < nums.length && nums[l] * 2 >= nums[r]) {
                for (int i = 0; i < totalBit; ++i) {
                    int offset = 1 << i;
                    if ((offset & nums[r]) > 0) {
                        map.get(offset).add(nums[r]);
                    }
                }
                ++r;
            }
//            System.out.println(map);
//            System.out.println();

            for (int i = 0; i < totalBit; i++) {
                int offset = 1 << i;
                if ((offset & nums[l]) == 0) {
                    for (int num : map.get(offset)) {
                        res = Math.max(num ^ nums[l], res);
                    }
                }
            }

            for (int i = 0; i < totalBit; i++) {
                int offset = 1 << i;
                if ((offset & nums[l])  > 0) {
                    map.get(offset).remove(nums[l]);
                }
            }

            ++l;

        }
        return res;
    }
}