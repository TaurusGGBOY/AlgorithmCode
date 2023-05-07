import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        if(nums.length<=1)
            return 1;
        int start = 0;
        int end = 1;
        int maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[start], 1);
        while (start < nums.length && end < nums.length) {
//            System.out.print(start);
//            System.out.print(" ");
//            System.out.println(end);
            if (start == end) {
                end++;
                continue;
            }
            if (map.getOrDefault(nums[end], 0) > 0) {

                map.merge(nums[end], 1, (oldval, newval) -> oldval + newval);
                maxLen = Math.max(end-start+1, maxLen);
                end++;
                continue;
            }
            if (getMaxMin(nums, start, end, limit)) {
//                System.out.println("pos4");
                map.merge(nums[end], 1, (oldval, newval) -> oldval + newval);
                maxLen = Math.max(end-start+1, maxLen);
                end++;
            } else {
//                System.out.println("pos6");
                if(map.containsKey(nums[start]))
                {
                    map.put(nums[start], map.get(nums[start]) - 1);
                }
                else
                {
                    map.put(nums[start], 0);
                }
//                System.out.println("pos7");
                start++;
//                System.out.println("pos8");
            }

        }
        return maxLen;
    }

    boolean getMaxMin(int[] nums, int start, int end, int limit) {
        int max = 0;
        int min = Integer.MAX_VALUE;
//        System.out.println("pos1");
        for (int i = start; i <= end; i++) {
//            System.out.println(i);
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
//        System.out.println("pos2");
        return max - min <= limit;
    }
}