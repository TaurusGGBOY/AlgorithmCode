import java.util.HashSet;
import java.util.Set;

class Solution {
    int[] parents;
    public int findCircleNum(int[][] isConnected) {
        parents = new int[isConnected.length];
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            parents[i] = i;
            set.add(i);
        }
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i+1; j < isConnected[0].length; j++) {
                if (isConnected[i][j]==1) {
                    int index1 = find(i);
                    int index2 = find(j);
                    merge(index1,index2);
                    set.remove(index1);
                    set.add(index2);
                }
            }
        }
        return set.size();
    }
    void merge(int index1,int index2){
        parents[index1] = index2;
    }

    int find(int index) {
        if(parents[index]!=index){
            return find(parents[index]);
        }
        return parents[index];
    }
}