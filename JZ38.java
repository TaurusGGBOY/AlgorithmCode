import java.util.*;

class Solution {
    List<String> res;

    public String[] permutation(String s) {
        res = new ArrayList<>();
        dfs(s.toCharArray(), 0);
        String[] strs = new String[res.size()];
        return res.toArray(strs);
    }

    void dfs(char[] c, int i) {
        // 重点1：只有在最后一层才把结果加入，之前相当于还没有构建好
        if (i == c.length-1) {
            res.add(new String(c));
            return;
        }
        // 重点2：因为我们其实只用关心第i个是否会有重复，所以记录后面会替换过来的就行
        Set<Character> set = new HashSet<>();
        for (int j = i; j < c.length; j++) {
            if(set.contains(c[j])) continue;
            set.add(c[j]);
            swap(c, i, j);
            dfs(c, i + 1);
            swap(c, i, j);
        }
    }

    void swap(char[] c, int i, int j) {
        char ch = c[i];
        c[i] = c[j];
        c[j] = ch;
    }
}