class Solution {
    int[] parents;
    public int[] findRedundantConnection(int[][] edges) {
        parents = new int[edges.length+1];
        for (int i = 0; i < edges.length+1; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            int index1 = find(edge[0]);
            int index2 = find(edge[1]);
            if (index1 != index2) {
                merge(index1, index2);
            }else{
                return edge;
            }
        }
        return new int[2];
    }

    void merge(int index1, int index2) {
        parents[index1]=index2;
    }

    int find(int index) {
        if(parents[index]!=index){
            return find(parents[index]);
        }
        return parents[index];
    }
}