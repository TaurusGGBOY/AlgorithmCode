import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) list.add(String.valueOf(num));
        list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        StringBuilder stringBuilder = new StringBuilder();
        for (String num : list) stringBuilder.append(num);
        if (stringBuilder.charAt(0) == '0') return "0";
        return stringBuilder.toString();
    }
}