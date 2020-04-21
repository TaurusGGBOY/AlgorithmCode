import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int pos = 0;
        Queue<Character> queue = new LinkedList<>();
        while (pos<letters.length&&letters[pos] <= target) {
            queue.add(letters[pos]);
            pos++;
        }
        for(int i=pos;i<letters.length;i++)
        {
            if(letters[i]>target)
                return letters[i];
        }
        return queue.poll();


    }
}