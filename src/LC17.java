import java.util.ArrayList;
import java.util.List;

class Solution {
    String[] nums = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty())
            return set;
        for (char num : nums[digits.charAt(0) - '0'].toCharArray()) {
            set.add(String.valueOf(num));
        }
        dfs(digits, 1);
        return set;
    }

    void dfs(String digits, int order) {
        if (order == digits.length())
            return;
        List<String> newList = new ArrayList<>();

        int len = set.size();
        for (int i = 0; i < len; i++) {
            for (char num : nums[digits.charAt(order) - '0'].toCharArray()) {
                newList.add(set.get(i) + num);
            }
        }
        set = newList;
        dfs(digits, order + 1);
    }
}