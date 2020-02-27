import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] findContinuousSequence(int target) {
        int l = 1;
        int r = 1;
        int sum = 0;
        Deque<Integer> queue = new LinkedList<>();
        int[][] returnList= new int[target][target];
        int row=0;
        for (int i = 1; i <= target / 2; i++) {
            while(r<=target/2+1)
            {
                queue.add(r);
                sum+=r;
                r++;
                while(sum>target)
                {
                    sum-=l;
                    l++;
                    queue.pollFirst();
                }
                if(sum==target)
                {
                    for(int j=l;j<=r;j++)
                    {
                        returnList[row][j-l]=j;
                    }
                    row++;
                }
            }
        }
    }
}