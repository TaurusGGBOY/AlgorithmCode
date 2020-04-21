import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Solution{
    public List<Boolean> prefixesDivBy5(int[] A)
    {
        List<Boolean> list = new ArrayList<>();
        int sum=0;
        for(int num:A)
        {
            sum=sum*2+num;
            if(sum>=10)
              sum-=10;
            list.add(sum%5==0);
        }
        return list;
    }
}