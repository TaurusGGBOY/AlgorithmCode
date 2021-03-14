class Solution {
    public int findCenter(int[][] edges) {
        int[] degree = new int[edges.length + 2];
        for (int[] edge : edges) {
            degree[edge[0]]++;
            if (degree[edge[0]] == edge.length) {
                return edge[0];
            }
            degree[edge[1]]++;
            if (degree[edge[1]] == edge.length) {
                return edge[1];
            }
        }
        return -1;
    }
}