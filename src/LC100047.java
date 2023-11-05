import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    int[][] sons;
    Set<Integer> zeroInDegree;
    long ans;
    Set<Integer> primes;

    public long countPaths(int n, int[][] edges) {
        System.out.println(Arrays.deepToString(edges));
        ans = 0;
        sons = new int[n + 1][2];
        for (int i = 0; i < sons.length; i++) {
            Arrays.fill(sons[i], -1);
        }

        zeroInDegree = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            zeroInDegree.add(i);
        }

        for (int[] edge : edges) {
            if (sons[edge[0]][0] == -1) {
                sons[edge[0]][0] = edge[1];
            } else {
                sons[edge[0]][1] = edge[1];
            }
            zeroInDegree.remove(edge[1]);
        }

        primes = new HashSet<>();
        getPrime(n);

        int start = zeroInDegree.iterator().next();
        dfs(start);

        return ans;
    }

    long[] dfs(int node) {
        long[] res = new long[2];
        if (node == -1) {
            return res;
        }

        long[] left = dfs(sons[node][0]);
        long[] right = dfs(sons[node][1]);

        if (isPrime(node)) {
            ans += (left[0] * right[0] != 0) ? left[0] * right[0] : Math.max(left[0], right[0]);
            res[1] = left[0] + right[0] + 1;
        } else {
            ans += right[1] * Math.max(left[0], 1);
            ans += left[1] * Math.max(right[0], 1);

            res[0] = left[0] + right[0] + 1;
            res[1] = left[1] + right[1];
        }

        System.out.println("node :" + node + ",res[0]:" + res[0] + ",res[1]:" + res[1] + ",ans:" + ans);
        System.out.println("left[0]: " + left[0] + ",left[1]: " + left[1] + ",right[0]: " + right[0] + ",right[1]: " + right[1]);

        return res;
    }

    void getPrime(int n) {
        loop:
        for (int j = 2; j <= n; j++) {
            for (int i = 2; i <= Math.sqrt(j); i++) {
                if (j % i == 0) {
                    continue loop;
                }
            }
            primes.add(j);
        }
        System.out.println(primes);
    }

    boolean isPrime(int num) {
        return primes.contains(num);
    }
}