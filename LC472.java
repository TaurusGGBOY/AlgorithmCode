import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Map<Integer, Set<String>> map = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            int hash = 0;
            for (char c : chars) {
                hash = hash * 31 + c - 'a';
            }
            Set<String> set = map.getOrDefault(hash, new HashSet<>());
            set.add(word);
            map.put(hash, set);
        }

        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (check(map, word)) {
                res.add(word);
            }
        }
        return res;
    }

    boolean check(Map<Integer, Set<String>> map, String word) {
        char[] chars = word.toCharArray();
        // max contain word count
        // dp[j] = Math.max(dp[j], dp[i] + 1);
        // 记录的其实是chars[j-1]处及之前的最多包含多少的有效字符串
        int[] dp = new int[word.length() + 1];
        // 如果开局就一个有效的都没有就不要继续往下进行了 至少保证i=0的时候 开局有一个单词是合法的吧
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < chars.length; i++) {
            if (dp[i] == -1) {
                continue;
            }
            int hashcode = 0;
            for (int j = i + 1; j <= chars.length; j++) {
                hashcode = hashcode * 31 + chars[j - 1] - 'a';
//                System.out.println(hashcode);
//                System.out.println(map.toString());
                if (map.containsKey(hashcode) && map.get(hashcode).contains(word.substring(i, j))) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            if (dp[chars.length] >= 2) {
                return true;
            }
        }
//        System.out.println(Arrays.toString(dp));
        return false;
    }


}
