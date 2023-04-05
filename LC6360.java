import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, AbstractMap.SimpleEntry<Integer, Long>> leftSum = new HashMap<>();
        Map<Integer, AbstractMap.SimpleEntry<Integer, Long>> rightSum = new HashMap<>();
        long[][] leftSumArr = new long[nums.length][2];
        long[][] rightSumArr = new long[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            if (leftSum.containsKey(nums[i])) {
                AbstractMap.SimpleEntry<Integer, Long> entry = leftSum.get(nums[i]);
                AbstractMap.SimpleEntry<Integer, Long> newEntry = new AbstractMap.SimpleEntry<Integer, Long>(entry.getKey() + 1, entry.getValue() + i);
                leftSum.put(nums[i], newEntry);
                leftSumArr[i][0] = newEntry.getKey();
                leftSumArr[i][1] = newEntry.getValue();
            } else {
                AbstractMap.SimpleEntry<Integer, Long> newEntry = new AbstractMap.SimpleEntry<Integer, Long>(1, i * 1L);
                leftSum.put(nums[i], newEntry);
                leftSumArr[i][0] = newEntry.getKey();
                leftSumArr[i][1] = newEntry.getValue();
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (rightSum.containsKey(nums[i])) {
                AbstractMap.SimpleEntry<Integer, Long> entry = rightSum.get(nums[i]);
                AbstractMap.SimpleEntry<Integer, Long> newEntry = new AbstractMap.SimpleEntry<Integer, Long>(entry.getKey() + 1, entry.getValue() + i);
                rightSum.put(nums[i], newEntry);
                rightSumArr[i][0] = newEntry.getKey();
                rightSumArr[i][1] = newEntry.getValue();
            } else {
                AbstractMap.SimpleEntry<Integer, Long> newEntry = new AbstractMap.SimpleEntry<Integer, Long>(1, i * 1L);
                rightSum.put(nums[i], newEntry);
                rightSumArr[i][0] = newEntry.getKey();
                rightSumArr[i][1] = newEntry.getValue();
            }
        }

        long[] res = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = i * leftSumArr[i][0] - leftSumArr[i][1] + rightSumArr[i][1] - i * rightSumArr[i][0];
        }
        return res;
    }
}