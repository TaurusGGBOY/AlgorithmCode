// TODO 失败
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        Map<Integer, Integer> parents1 = new HashMap<>();
        Map<Integer, Integer> parents2 = new HashMap<>();
        Set<Integer> island1 = new HashSet<>();
        Set<Integer> island2 = new HashSet<>();
        for (int i = 0; i < grid1.length * grid1[0].length; i++) {
            int row = i / grid1[0].length;
            int col = i % grid1[0].length;
            if (grid1[row][col] == 1) {
                parents1.put(i, i);
            }
            if (grid2[row][col] == 1) {
                parents2.put(i, i);
            }
        }
        mapIsland(parents1, grid1);
        mapIsland(parents2, grid2);
        for (int i = 0; i < grid1.length * grid1[0].length; i++) {
            int row = i / grid1[0].length;
            int col = i % grid1[0].length;
            if (grid2[row][col] == 1) {
                island2.add(find(parents2, i));
            }
        }
//        System.out.println(parents2.toString());
//        System.out.println(island2.toString());
        for (int i = 0; i < grid1.length * grid1[0].length; i++) {
            int row = i / grid1[0].length;
            int col = i % grid1[0].length;
            if (grid1[row][col] == 0 && grid2[row][col] == 1) {
                int parent2 = find(parents2, i);
                island2.remove(parent2);
            }
        }
//        System.out.println(island2.toString());
//        System.out.println();
        return island2.size();
    }

    void mapIsland(Map<Integer, Integer> parents, int[][] grid) {
        for (int i = 0; i < grid.length * grid[0].length; i++) {
            int row = i / grid[0].length;
            int col = i % grid[0].length;
            if (grid[row][col] == 0) {
                continue;
            }
            try {
                if (grid[row - 1][col] == 1) {
                    merge(parents, i - grid[0].length, i);
                }
            } catch (Exception e) {
            }
            try {
                if (grid[row][col - 1] == 1) {
                    merge(parents, i - 1, i);
                }
            } catch (Exception e) {
            }
            try {
                if (grid[row][col + 1] == 1) {
                    merge(parents, i, i + 1);
                }
            } catch (Exception e) {
            }
            try {
                if (grid[row + 1][col] == 1) {
                    merge(parents, i, i + grid[0].length);
                }
            } catch (Exception e) {
            }
        }
    }

    int find(Map<Integer, Integer> parents, int index) {
        if (parents.getOrDefault(index, index) == index) {
            return index;
        }
        return find(parents, parents.get(index));
    }

    void merge(Map<Integer, Integer> parents, int parent, int index) {
        parents.put(index, find(parents, parent));
    }
}