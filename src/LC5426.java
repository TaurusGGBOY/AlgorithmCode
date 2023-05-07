import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

class Solution {
    public int minReorder(int n, int[][] connections) {
        Set<Integer> set = new HashSet<>();
        Vector<int[]> vector = new Vector<>();
        for (int[] temp : connections) {
            vector.add(temp);
        }
        Iterator<int[]> iterator = vector.iterator();
        set.add(0);
        int count = 0;
        int i = 0;
        while (!vector.isEmpty()) {
            iterator = vector.iterator();
            while (iterator.hasNext()) {
                int[] temp = iterator.next();
//                System.out.println("第" + i++);
//                System.out.println(temp[0]);
//                System.out.println(temp[1]);
                if (set.contains(temp[1])) {
                    set.add(temp[0]);
                    iterator.remove();
                } else if (set.contains(temp[0])) {
                    count++;
                    set.add(temp[1]);
                    iterator.remove();
                }
            }
        }
        return count;
    }
}