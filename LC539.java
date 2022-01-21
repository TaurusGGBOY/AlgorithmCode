import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        timePoints.sort((o1, o2) -> {
            String[] s1 = o1.split(":");
            String[] s2 = o2.split(":");
            int t1 = Integer.parseInt(s1[0]) * 60 + Integer.parseInt(s1[1]);
            int t2 = Integer.parseInt(s2[0]) * 60 + Integer.parseInt(s2[1]);
            return t1 - t2;
        });
        int min = Integer.MAX_VALUE;
        timePoints.add(timePoints.get(0));
        for (int i = 0; i < timePoints.size()-1; i++) {
            String[] s1 = timePoints.get(i).split(":");
            String[] s2 = timePoints.get(i+1).split(":");
            int t1 = Integer.parseInt(s1[0]) * 60 + Integer.parseInt(s1[1]);
            int t2 = Integer.parseInt(s2[0]) * 60 + Integer.parseInt(s2[1]);
            min = Math.min(Math.abs(t2 - t1), min);
            min = Math.min(60 * 24 - Math.abs(t2 - t1), min);
        }

        return min;
    }
}