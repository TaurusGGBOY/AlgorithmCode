class Solution {
    public int deleteString(String s) {
        char[] chars = s.toCharArray();
        int pos = 0;
        int max = 1;
        for (int i = 0; i < chars.length; i++) {
            chars[pos++] = chars[i];
            if (pos % 2 == 1) continue;
            boolean flag = true;
            for (int j = 0; j < pos / 2; j++) {
                if (chars[j] != chars[j + pos / 2]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(i);
                System.out.println(pos);
                pos = pos / 2;
                System.out.println(pos);
                max++;
            }
        }
        System.out.println();
        return max;
    }
}