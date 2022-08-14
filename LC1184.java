class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int sum = 0,dis = 0;
        for (int d : distance) sum += d;
        for (int i = Math.min(start,destination); i < Math.max(start,destination); i++) dis += distance[i];
        return Math.min(dis, sum - dis);
    }
}