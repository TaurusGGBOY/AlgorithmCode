// TODO 失败
import java.util.*;

class Solution {
    Map<Integer, Set<Integer>> cannotFriends;
    int[] parents;

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        // 自己维护一个列表 这些人不能成为朋友
        cannotFriends = new HashMap<>();
        for (int[] restriction : restrictions) {
            addCannotFriends(restriction[0], restriction[1]);
        }

        boolean[] res = new boolean[requests.length];

        for (int i = 0; i < requests.length; i++) {
            // 检查是否能成为朋友
            if (checkFriends(requests[i][0], requests[i][1])) {
                res[i] = true;
                // 如果能 就让我的父母 认别人的父母为父母
                addFriends(requests[i][0], requests[i][1]);
            } else {
                res[i] = false;
                addCannotFriends(requests[i][0], requests[i][1]);
            }
        }
        return res;
    }

    int find(int index) {
        // 找最大的父母
        return parents[index] == index ? index : find(parents[index]);
    }

    void merge(int parent, int index) {
        // 路径压缩
        parents[find(index)] = find(parent);
    }

    void addFriends(int u1, int u2) {
        // 寻找我的父母
        int p1 = find(u1);
        int p2 = find(u2);
        // 将我的父母和别人父母的不能交友列表合并
        mergeCannot(p1, p2);
        // 将别人的父母认作最大的
        merge(p1, p2);
    }

    void mergeCannot(int p1, int p2) {
        Set<Integer> set = cannotFriends.getOrDefault(p1, new HashSet<>());
        set.addAll(cannotFriends.getOrDefault(p2, new HashSet<>()));
        cannotFriends.put(p1, set);
    }

    void addCannotFriends(int u1, int u2) {
        int p1 = find(u1);
        int p2 = find(u2);

        Set<Integer> set1 = cannotFriends.getOrDefault(p1, new HashSet<>());
        Set<Integer> set2 = cannotFriends.getOrDefault(p2, new HashSet<>());
        set1.add(p2);
        set2.add(p1);
        cannotFriends.put(p1, set1);
        cannotFriends.put(p2, set2);
    }

    boolean checkFriends(int u1, int u2) {
        int p1 = find(u1);
        int p2 = find(u2);

        if (p1 == p2) {
            return true;
        }

        // check whether parents can be friends.
        Set<Integer> set1 = cannotFriends.getOrDefault(p1, new HashSet<>());
        if (set1.contains(p2)) {
            return false;
        }

        Set<Integer> set2 = cannotFriends.getOrDefault(p2, new HashSet<>());
        if (set2.contains(p1)) {
            return false;
        }
        return true;
    }
}