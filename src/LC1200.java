import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiv = Integer.MAX_VALUE;
        List<List<Integer>> allList = new ArrayList<>();
        List<Integer> list;
        for (int i = 0; i < arr.length - 1; i++) {
            int temp = Math.abs(arr[i] - arr[i + 1]);
            if(temp<minDiv)
            {
                minDiv=temp;
                allList.clear();
                list = new ArrayList<>();
                list.add(Math.min(arr[i], arr[i + 1]));
                list.add(Math.max(arr[i], arr[i + 1]));
                allList.add(list);
                continue;
            }
            if (temp == minDiv) {
                list = new ArrayList<>();
                list.add(Math.min(arr[i], arr[i + 1]));
                list.add(Math.max(arr[i], arr[i + 1]));
                allList.add(list);
            }

        }
        return allList;
    }
}