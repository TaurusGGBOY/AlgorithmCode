import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int minx = Integer.MAX_VALUE, miny = Integer.MAX_VALUE, maxx = 0, maxy = 0;
        int area = 0;
        Set<AbstractMap.SimpleEntry<Integer, Integer>> set = new HashSet<>();
        for (int[] rectangle : rectangles) {
            minx = Math.min(rectangle[0], minx);
            miny = Math.min(rectangle[1], miny);
            maxx = Math.max(rectangle[2], maxx);
            maxy = Math.max(rectangle[3], maxy);
            area += (rectangle[3] - rectangle[1]) * (rectangle[2] - rectangle[0]);
            AbstractMap.SimpleEntry<Integer, Integer> point1 = new AbstractMap.SimpleEntry<Integer, Integer>(rectangle[0], rectangle[1]);
            AbstractMap.SimpleEntry<Integer, Integer> point2 = new AbstractMap.SimpleEntry<Integer, Integer>(rectangle[0], rectangle[3]);
            AbstractMap.SimpleEntry<Integer, Integer> point3 = new AbstractMap.SimpleEntry<Integer, Integer>(rectangle[2], rectangle[1]);
            AbstractMap.SimpleEntry<Integer, Integer> point4 = new AbstractMap.SimpleEntry<Integer, Integer>(rectangle[2], rectangle[3]);
            if (set.contains(point1)) {
                set.remove(point1);
            } else {
                set.add(point1);
            }
            if (set.contains(point2)) {
                set.remove(point2);
            } else {
                set.add(point2);
            }
            if (set.contains(point3)) {
                set.remove(point3);
            } else {
                set.add(point3);
            }
            if (set.contains(point4)) {
                set.remove(point4);
            } else {
                set.add(point4);
            }
        }
        if (set.size() != 4) {
            return false;
        }
        if (area != (maxy - miny) * (maxx - minx)) {
            return false;
        }
        if (!set.contains(new AbstractMap.SimpleEntry<>(minx, miny))) {
            return false;
        }
        if (!set.contains(new AbstractMap.SimpleEntry<>(minx, maxy))) {
            return false;
        }
        if (!set.contains(new AbstractMap.SimpleEntry<>(maxx, miny))) {
            return false;
        }
        if (!set.contains(new AbstractMap.SimpleEntry<>(maxx, maxy))) {
            return false;
        }
        return true;
    }
}