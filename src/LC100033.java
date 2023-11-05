import java.util.*;

class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int res = 0;
        for (List<Integer> list : composition) {
            res = Math.max(check(budget, list, stock, cost), res);
        }
//        System.out.println();
        return res;
    }

    public int check(int budget, List<Integer> c, List<Integer> stock, List<Integer> cost) {
        long l = 0;
        long r = 2000000001;

        long res = l;
        while (l <= r) {
            long m = l + (r - l) / 2;
            if (fit(budget, m, c, stock, cost)) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
//        System.out.println(c);
//        System.out.println(res);
        return (int) res;
    }

    public boolean fit(long budget, long num, List<Integer> c, List<Integer> stock, List<Integer> cost) {
        for (int i = 0; i < c.size(); i++) {
            if (stock.get(i) >= num * (long) (c.get(i))) {
                continue;
            }

            budget -= (num * (long) (c.get(i)) - (long) (stock.get(i))) * (long) (cost.get(i));
            if (budget < 0) {
                return false;
            }
        }

        return true;
    }
}