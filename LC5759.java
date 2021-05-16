import java.util.ArrayList;
import java.util.List;

class Solution {
    public int subsetXORSum(int[] nums) {
        List<List<Integer>> listlist = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            String lenthBiString = Integer.toBinaryString(i);
            List<Integer> numList = new ArrayList<>();
            int temp = 0;
            for (int j = 0; j < lenthBiString.length(); j++)
                if (lenthBiString.charAt(j) == '1') {
                    numList.add(nums[lenthBiString.length() - j - 1]);
                    temp ^= nums[lenthBiString.length() - j - 1];
                }
            sum += temp;
            listlist.add(numList);
        }
        return sum;
    }
}
