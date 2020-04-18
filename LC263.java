class Solution {
    public boolean isUgly(int num) {
        if(num==0)
            return false;
        int[] ele = {2, 3, 5};
        int flag=0;
        while(num!=1)
        {

            flag=0;
            for(int i=0;i<ele.length;i++)
            {
                if(num%ele[i]==0)
                {
                    num/=ele[i];
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                return false;
        }
        return true;
    }
}