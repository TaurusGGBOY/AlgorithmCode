import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Set<Integer> set = Arrays.stream(numbers).boxed().collect(Collectors.toSet());
        int find = 0;
        for (int number : numbers) {
            if (set.contains(target - number)) {
                find = number;
                break;
            }
        }
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        return new int[]{list.indexOf(find)+1,list.lastIndexOf(target-find)+1};
    }
}