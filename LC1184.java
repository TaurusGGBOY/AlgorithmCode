class Solution {
    int sum=0;
    int temp=0;
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    for (int i = 0; i < distance.length; i++) {
        sum+=distance[i];
        if(i>=Math.min(start,destination)&&i<Math.max(start,destination))
        {
            temp+=distance[i];
        }
    }
    return Math.min(temp, sum - temp);
    }
}