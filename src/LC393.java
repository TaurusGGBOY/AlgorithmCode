import java.util.ArrayList;

class Solution {
    public boolean validUtf8(int[] data) {
        if (data.length <= 0) return false;
        String first = toByte(data[0]);
        int len = 0;
//        System.out.println(first);
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) == '1') len++;
            else break;
        }
        System.out.println(len);
        System.out.println();
        if (len >= data.length || len > 4 || data.length > 4) return false;
        for (int i = 1; i < len; i++) {
            String temp = toByte(data[i]);
            if (!temp.startsWith("10")) return false;
        }
        return true;
    }

    String toByte(int data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            stringBuilder.append(data & 1);
            data >>= 1;
        }
        System.out.println(stringBuilder.reverse().toString());
        stringBuilder.reverse();
        return stringBuilder.reverse().toString();
    }

}