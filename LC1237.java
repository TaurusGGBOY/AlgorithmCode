import java.util.ArrayList;
import java.util.List;

/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
// 不喜欢这种题
class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= z; i++) {
            for (int j = 1; j <= z; j++) {
                if (customfunction.f(i, j) > z)
                    break;

                if (customfunction.f(i, j) == z) {
                    temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }
        return list;
    }
}