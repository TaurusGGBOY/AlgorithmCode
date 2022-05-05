import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int x = 1;
        while (list.size() < n) {
            while (x <= n) {
                list.add(x);
                x *= 10;
            }
            while ((x % 10) == 9 || x > n) {
                x /= 10;
            }
            x++;
        }
        return list;
    }
}