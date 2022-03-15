import java.util.*;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) map.put(list1[i], i);

        List<String> list = new ArrayList<>();
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (!map.containsKey(list2[i])) continue;
            int temp = map.get(list2[i]) + i;
            if (temp > sum) continue;
            if (temp < sum) {
                sum = temp;
                list.clear();
            }
            list.add(list2[i]);
        }
        return list.toArray(new String[list.size()]);
    }
}