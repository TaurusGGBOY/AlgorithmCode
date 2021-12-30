class Solution {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int[] res = cal(chars, 0, 0);
        return res[0];
    }

    int[] cal(char[] chars, int start, int layer) {
        // res[0] == sum
        // res[1] == end
//        System.out.println(start + " " + layer);
        int[] res = new int[2];
        int i = start;
        boolean plus = true;
        while (i < chars.length) {
            char c = chars[i];
            switch (c) {
                case '+':
                    plus = true;
                    break;
                case '-':
                    plus = false;
                    break;
                case '(':
                    int[] temp = cal(chars, i + 1, layer + 1);
                    res[0] += plus ? temp[0] : -temp[0];
                    i = temp[1];
                    break;
                case ')':
                    if (layer > 0) {
                        res[1] = i;
                        return res;
                    }
                    break;
                case ' ':
                    break;
                default:
                    int num = chars[i] - '0';
                    while (i + 1 < chars.length && chars[i + 1] >= '0' && chars[i + 1] <= '9') {
                        num = num * 10 + chars[i + 1] - '0';
                        i++;
                    }
                    res[0] += plus ? num : -num;
                    break;
            }
            i++;
        }
        res[1] = i;
//        System.out.println("res:" + res[0] + " " + res[1]);
        return res;
    }
}