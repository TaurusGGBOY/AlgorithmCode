class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasN = 0;
        int flag=0;
        for(int i =0;i<gas.length;i++)
        {
            flag=1;
            gasN+=gas[i]-cost[i];
            if(gasN<0)
            {
                flag=0;
                break;
            }
        }
        if(flag==1)
            return 0;
        flag=0;
        for(int i =1;i<gas.length;i++)
        {
            gasN = 0;
            flag=i;
            for(int j=i;j<gas.length;j++)
            {
                gasN+=gas[j]-cost[j];
                if(gasN<0)
                {
                    flag=0;
                    break;
                }
            }
            for(int j=0;j<i;j++)
            {
                gasN+=gas[j]-cost[j];
                if(gasN<0)
                {
                    flag=0;
                    break;
                }
            }
            if(flag==i)
                break;
        }
        return flag==0?-1:flag;
    }
}