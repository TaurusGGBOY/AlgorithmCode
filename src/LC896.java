class Solution {
    public boolean isMonotonic(int[] A) {
        int[] temp = new int[A.length];
        if(A.length<=2)return true;
        int count1=0;
        int count2=0;
        for(int i=0;i<A.length-1;i++)
        {
            temp[i]=A[i+1]-A[i];
            if(temp[i]<0)
                count1++;
            else  if(temp[i]>0)
                count2++;

        }
        return count1 == 0 || count2 == 0;

    }
}