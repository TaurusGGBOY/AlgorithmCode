import java.util.Vector;

class Solution {
    public int maxDistToClosest(int[] seats) {
        int lastPos = 0;
        int maxDis = 0;
        int i = 0;
        int first=0;
        while (seats[i] == 0)
        {
            first++;
            i++;
        }
        for (; i < seats.length; i++) {
            if (seats[i] == 1) {
                maxDis = Math.max(maxDis, i - lastPos);
                lastPos = i;
            }
        }
        int max=Math.max((maxDis) / 2, seats.length - 1 - lastPos);

        return Math.max(max, first);
    }
}