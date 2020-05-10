import java.math.BigInteger;

class Solution {
    public int mySqrt(int x) {
        if(x==0)
            return 0;
        if(x==1)
            return 1;
        if(x==2)
            return 1;
        if(x==3)
            return 1;
        if(x==4)
            return 2;
        BigInteger xb = BigInteger.valueOf(x);
        BigInteger i = BigInteger.valueOf(2);
        BigInteger j = BigInteger.valueOf(x/2);

        while(!i.equals(j))
        {
            if(i.multiply(i).compareTo(xb) <= 0 && i.add(BigInteger.ONE).multiply(i.add(BigInteger.ONE)).compareTo(xb) >0 )
                break;
            BigInteger k= i.add(j).divide(BigInteger.valueOf(2));
            if(k.multiply(k).compareTo(xb)>0)
                j=k;
            else if (k.multiply(k).compareTo(xb)==0)
                i=k;
            else
                i=k;
        }
        return i.intValue();
    }
}