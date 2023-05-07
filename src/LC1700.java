import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < students.length; i++) {
            deque.offerLast(students[i]);
        }
        int pos = 0;
        while (true) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int s = deque.pollFirst();
                if (s == sandwiches[pos]) {
                    pos++;
                } else {
                    deque.offerLast(s);
                }
            }
            if (size == deque.size()) break;
        }
        return deque.size();
    }
}