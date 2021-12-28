import java.util.*;

class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        Map<Integer, Set<Integer>> requests = new HashMap<>();
        int count = 0;
        for (int i = 0; i < ages.length; i++) {
            int l = 0;
            int r = i - 1;
            int start = -1;
            int end = -1;
            if (ages[i] < 100) {
                continue;
            }
            while (l < r) {
                int m = (l + r) / 2;
                if (check(ages, i, m)) {
                    start = Math.min(m,start);
                    end = Math.max(m,end);
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
            l = 0;
            r = i - 1;
            while (l < r) {
                int m = (l + r) / 2;
                if (check(ages, i, m)) {
                    start = Math.min(m,start);
                    end = Math.max(m,end);
                }
                l = m + 1;
            }
            for (int j = start; j <= end; j++) {
                count += addIfNotExist(requests, j, i);
            }
        }
        return count;
    }

    boolean check(int[] ages, int x, int y) {
        if (ages[y] <= 0.5 * ages[x] + 7 || ages[y] > ages[x] || ages[y] > 100) {
            return false;
        }
        return true;
    }

    int addIfNotExist(Map<Integer, Set<Integer>> requests, int x, int y) {
        Set<Integer> xSet = requests.getOrDefault(x, new HashSet<>());
        if (xSet.contains(y)) {
            return 0;
        }
        Set<Integer> ySet = requests.getOrDefault(y, new HashSet<>());
        ySet.add(x);
        requests.put(y, ySet);
        return 1;
    }
}