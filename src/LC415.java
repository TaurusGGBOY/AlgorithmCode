import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int pos1 = num1.length() - 1, pos2 = num2.length() - 1, inBit = 0; pos1 >= 0 || pos2 >= 0 || inBit != 0; pos1--, pos2--) {
            int l = pos1 < 0 ? 0 : num1.charAt(pos1) - '0';
            int r = pos2 < 0 ? 0 : num2.charAt(pos2) - '0';
            int temp = l + r + inBit;
            inBit = temp / 10;
            temp = temp % 10;
            stringBuilder.append(temp);
        }
        return stringBuilder.reverse().toString();
    }
}