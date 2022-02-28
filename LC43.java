
class Solution {
    public String multiply(String num1, String num2) {
        // 存储从低位到高位
        int[] res = new int[40001];

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        //              123
        //             *456
        //             -----
        //              738
        //             6150
        //            49400
        for (int i = chars2.length - 1; i >= 0; i--) {
            int bias = chars2.length - 1 - i;
            int carry = 0;
            int index = 0;
            for (int j = chars1.length - 1; j >= 0; j--, index++) {
                int temp = (chars1[j] - '0') * (chars2[i] - '0') + carry + res[index + bias];
                res[index + bias] = temp % 10;
                carry = temp / 10;
            }
            while (carry != 0) {
                int temp = carry + res[index + bias];
                res[index + bias] = temp % 10;
                carry = temp / 10;
            }
//            toString(res, 0, 6);
        }
        int end = res.length - 1;
        while (end > 0 && res[end] == 0) end--;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= end; i++) stringBuilder.append((char) (res[i] + '0'));
        return stringBuilder.reverse().toString();
    }

    void toString(int[] res, int start, int end) {
        for (; start < end; start++) {
            System.out.print(res[start] + " ");
        }
        System.out.println();
    }
}