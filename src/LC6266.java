import java.util.*;

class Solution {
    Set<Integer> set;
    List<Integer> list;
    Map<Integer, Integer> map;

    public int smallestValue(int n) {
        set = new HashSet<>();
        list = new ArrayList<>();
        map = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                set.add(i);
                list.add(i);
            }
        }
        int res = dfs(n);
//        System.out.println(map);
        return res;
    }

    int dfs(int n) {
        if (set.contains(n)) return n;
        int rep = replace(n);
        if (rep == n) return n;
        return dfs(rep);
    }

    boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    int replace(int n) {
//        System.out.println("replace " + n);
        int sum = 0;
        if (map.containsKey(n)) return map.get(n);
        for (int temp : list) {
            if (set.contains(n)) {
                map.put(n, n);
                return n;
            }
            if (temp >= n) {
                map.put(n, n);
                return n;
            }
            if (n % temp == 0) {
//                System.out.println(n + " " + temp);
                sum = temp + replace(n / temp);
                break;
            }
        }
        map.put(n, sum);
        return sum;
    }


}