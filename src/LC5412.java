class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int[] arr = new int[1001];
        for(int i =0;i<startTime.length;i++)
        {
            if(startTime[i]>queryTime)
                continue;
            for(int j =startTime[i];j<=endTime[i]&&j<=queryTime;j++)
            {
                arr[j]++;
            }
        }
        return arr[queryTime];
    }
}