import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);

        Map<Integer, Integer> group = new HashMap<>();
        Map<Integer, List<Integer>> readyList = new HashMap<>();
        Map<Integer, Integer> indices = new HashMap<>();

        int begin = temp[0];
        final int finalBegin = begin;
        readyList.put(begin, new ArrayList<>() {{
            add(finalBegin);
        }});
        indices.put(begin, 0);
        group.put(begin, begin);

        for (int i = 1; i < temp.length; ++i) {
            int num = temp[i];
            List<Integer> list = readyList.get(begin);
            if (num - list.get(list.size() - 1) <= limit) {
                group.put(num, begin);
                list.add(num);
            } else {
                begin = num;
                final int finalBeginTemp = begin;
                readyList.put(begin, new ArrayList<>() {{
                    add(finalBeginTemp);
                }});
                indices.put(begin, 0);
                group.put(begin, begin);
            }
        }

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int parent = group.get(num);
            List<Integer> list = readyList.get(parent);
            int index = indices.get(parent);

            res[i] = list.get(index);
            indices.put(parent, index + 1);
//            System.out.println(list);
        }

        return res;
    }
}