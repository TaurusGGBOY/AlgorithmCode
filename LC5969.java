import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long temp = mass;
        for (int i = 0; i < asteroids.length; i++) {
            if (temp < asteroids[i]) {
                return false;
            }
            temp += asteroids[i];
        }
        return true;
    }
}