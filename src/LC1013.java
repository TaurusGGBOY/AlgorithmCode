class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum =0;
        for (int num : A) {
            sum += num;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int sinSum = sum / 3;
        int temp=0;
        for (int i = 0; i < A.length; i++) {
            temp+=A[i];
            if(temp==sinSum)
            {
                for(int j=i+1;j<A.length;j++)
                {
                    temp+=A[j];
                    if(temp==2*sinSum)
                    {
                        if(j==A.length-1)
                            return false;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}