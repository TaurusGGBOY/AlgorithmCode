import java.util.LinkedList;
import java.util.List;

class Solution {
    public String makeGood(String s) {
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (list.isEmpty())
                list.addLast(c);
            else {
                if (Math.abs(list.getLast() - c) == 32) {
                    list.removeLast();
                }
                else
                    list.addLast(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : list) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}