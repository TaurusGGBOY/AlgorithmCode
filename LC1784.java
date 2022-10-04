import java.util.Arrays;

class Solution {
    public boolean checkOnesSegment(String s) {
        String[] strs = s.split("0+");
//        System.out.println(Arrays.toString(strs));
//        System.out.println();
        return strs.length <= 1;
    }
}