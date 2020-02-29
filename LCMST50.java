import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public char firstUniqChar(String s) {
        int[] start = new int[26];
        int[] times = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (times[c - 'a'] == 0) {
                start[c - 'a'] = i;
                times[c - 'a'] = 1;
            } else {
                times[c - 'a']++;
            }
        }
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            if (times[i] == 1) {
                queue.add(start[i]);
            }
        }
        if (queue.isEmpty())
            return ' ';
        else
            return (char) +s.charAt(queue.peek());
    }
}