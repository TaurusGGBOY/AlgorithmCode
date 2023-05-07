import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

class Solution {
    public boolean isPathCrossing(String path) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int startx = 0;
        int starty = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(starty);
        map.put(startx, arrayList);
        for (char c : path.toCharArray()) {
            switch (c) {
                case 'N':
                    starty++;
                    if (map.getOrDefault(startx, new ArrayList<>()).contains(starty))
                        return true;
                    arrayList = map.get(startx);
                    arrayList.add(starty);
                    map.put(startx, arrayList);
                    break;
                case 'S':
                    starty--;
                    if (map.getOrDefault(startx, new ArrayList<>()).contains(starty))
                        return true;
                    arrayList = map.get(startx);
                    arrayList.add(starty);
                    map.put(startx, arrayList);
                    break;
                case 'W':
                    startx--;
                    if (!map.containsKey(startx)) {
                        arrayList = new ArrayList<>();
                        arrayList.add(starty);
                        map.put(startx, arrayList);
                    } else if (map.getOrDefault(startx, new ArrayList<>()).contains(starty))
                        return true;
                    else {
                        arrayList = map.get(startx);
                        arrayList.add(starty);
                        map.put(startx, arrayList);
                    }
                    break;
                case 'E':
                    startx++;
                    if (!map.containsKey(startx)) {
                        arrayList = new ArrayList<>();
                        arrayList.add(starty);
                        map.put(startx, arrayList);
                    } else if (map.getOrDefault(startx, new ArrayList<>()).contains(starty))
                        return true;
                    else {
                        arrayList = map.get(startx);
                        arrayList.add(starty);
                        map.put(startx, arrayList);
                    }
                    break;

            }
        }
        return false;
    }
}