import java.util.Arrays;

class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;
        int l = 0;
        int r = s.length();
        int m = l + (r - l) / 2;
        int[] counter = new int[3];
        Arrays.fill(counter, -k);


        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }
//        System.out.println(Arrays.toString(counter));
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] < 0) return -1;
        }

        // 首先 left窗口肯定是满足条件的
        // right不一定满足
        // 二分法找窗口
//        System.out.println();
        int res = l;
        while (l <= r) {
//            System.out.println(l + " " + r + " " + m);
            boolean flag = false;
            int[] temp = new int[3];
            for (int i = 0; i < m; i++) {
                temp[s.charAt(i) - 'a']++;
            }
//            System.out.println(Arrays.toString(temp));
            // 如果这个条件下满足题目条件 那么left是可以等于m的
            if (fit(counter, temp)) flag = true;
            for (int i = m; i < s.length(); i++) {
                temp[s.charAt(i - m) - 'a']--;
                temp[s.charAt(i) - 'a']++;
//                System.out.println(Arrays.toString(temp));
                // 如果这个条件下满足题目条件 那么left是可以等于m的
                if (fit(counter, temp)) {
                    flag = true;
                    break;
                }
            }
//            int sum = l + r + m;

            if (flag) {
                res = m;
                l = m + 1;
            } else r = m - 1;
            m = l + (r - l) / 2;
//            if (sum == l + m + r) break;
        }
//        System.out.println();
        return s.length() - res;
    }

    boolean fit(int[] counter, int[] temp) {
        for (int i = 0; i < counter.length; i++) {
            // 这个就是不满足题目条件了
            if (counter[i] < temp[i]) return false;
        }
        return true;
    }
}