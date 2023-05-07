import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

class Solution {
    static int[][] alphas;
    static int[] visited;
    static int[] res;
    static int[] layout;
    static int[] kids;

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        layout = new int[n];
        alphas = new int[n][26];
        visited = new int[n];
        res = new int[n];
        layout[0] = 1;
        kids = new int[26];
        Vector<int[]> edgesList = new Vector<>();

        for (int[] edge : edges)
            edgesList.add(edge);
        Iterator<int[]> listIterator = edgesList.listIterator();
        bfs(edgesList, labels, 0, listIterator);
        return res;
    }

    void bfs(Vector<int[]> edgesList, String labels, int num, Iterator<int[]> listIterator) {
        if (visited[num] == 1)
            return;
        listIterator = edgesList.listIterator();

        while (listIterator.hasNext()) {
            int edge[] = listIterator.next();
            if (kids[num] == 2)
                break;
            if (edge[0] == num) {
                if (layout[edge[1]] == 0)
                    layout[edge[1]] = layout[num] + 1;
                if (layout[edge[1]] < layout[num])
                    continue;
                listIterator.remove();
                bfs(edgesList, labels, edge[1], listIterator);
                kids[num]++;
                for (int i = 0; i < 26; i++) {
                    alphas[num][i] += alphas[edge[1]][i];
                }
            } else if (edge[1] == num) {
                if (layout[edge[0]] == 0)
                    layout[edge[0]] = layout[num] + 1;
                if (layout[edge[0]] < layout[num])
                    continue;
                listIterator.remove();
                bfs(edgesList, labels, edge[0], listIterator);
                kids[num]++;
                for (int i = 0; i < 26; i++) {
                    alphas[num][i] += alphas[edge[0]][i];
                }
            }
        }
        alphas[num][labels.charAt(num) - 'a']++;
        res[num] = alphas[num][labels.charAt(num) - 'a'];
        visited[num] = 1;
    }

}
//4
//        [[0,2],[0,3],[1,2]]
//        "aeed"
//输入：
//        4
//        [[0,2],[0,3],[1,2]]
//        "aeed"
//        输出：
//        [1,0,1,1]
//        预期：
//        [1,1,2,1]