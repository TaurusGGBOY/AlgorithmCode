import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    StringBuilder stringBuilder = new StringBuilder();
    List<String> res;

    List<String> expand(String s) {
        res = new ArrayList<>();
        String[] strs = s.split("[{}]");
        List<List<String>> list = new ArrayList<>();
        for (String str : strs) {
            if (str.isEmpty()) continue;
            String[] split = str.split(",");
            List<String> temp = new ArrayList<>(Arrays.asList(split));
            list.add(temp);
        }
        dfs(list, 0);
        return res;
    }

    void dfs(List<List<String>> list, int depth) {
        if (depth == list.size()) {
            res.add(list.toString());
            return;
        }
        List<String> temp = list.get(depth);
        for (String s : temp) {
            stringBuilder.append(s);
            dfs(list, depth + 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}