import java.util.ArrayList;
import java.util.List;

class Solution {
    StringBuilder stringBuilder;

    public long kMirror(int k, int n) {
        List<Integer> list = new ArrayList<>();
        stringBuilder = new StringBuilder();
        stringBuilder.append('1');
        list.add(1);
        list.add(1);
        dfs(1, '0')
        list.sort(null);
        long res = 0;
        for (int i = 0; i < k; i++) {
            res += list.get(i);
        }
        return res;
    }

    void dfs(int depth, char c, int maxDepth){
        if(depth>maxDepth)
        dfs(depth + 1, '0', maxDepth);
        dfs(depth + 1, '1', maxDepth);
    }


}