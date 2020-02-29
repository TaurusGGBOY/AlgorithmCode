
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> listlist = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++) {

            String lenthBiString = Integer.toBinaryString(i);

            List<Integer> numList = new ArrayList<>();

            for (int j = 0; j < lenthBiString.length(); j++)
                if (lenthBiString.charAt(j) == '1')
                    numList.add(nums[lenthBiString.length() - j - 1]);

            listlist.add(numList);
        }
        return listlist;
    }
}