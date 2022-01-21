import java.util.*;

class Solution {
    final static int MOD = 1000000007;
    Map<Character, List<Character>> map;
    int[][] count;

    public int countVowelPermutation(int n) {
        map = new HashMap<>();
        count = new int[26][20001];
        map.put('a', new ArrayList<>(Arrays.asList('e')));
        map.put('e', new ArrayList<>(Arrays.asList('a', 'i')));
        map.put('i', new ArrayList<>(Arrays.asList('a', 'e', 'o', 'u')));
        map.put('o', new ArrayList<>(Arrays.asList('i', 'u')));
        map.put('u', new ArrayList<>(Arrays.asList('a')));
        char[] chars = new char[]{'a', 'e', 'i', 'o', 'u'};
        long res = 0;
        for (char c : chars) res = (res + dfs(n - 1, c)) % MOD;
        return (int) res;
    }

    int dfs(int remind, char c) {
        if (count[c - 'a'][remind] != 0) return count[c - 'a'][remind];
        List<Character> list = map.get(c);
        if (remind == 0) return 1;
        if (remind == 1) return list.size();
        long res = 0;
        for (char ch : list) res = (res + dfs(remind - 1, ch)) % MOD;
        count[c - 'a'][remind] = (int) res;
        return (int) res;
    }
}