class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        if(arr.length<3)
            return false;
        int count = 0;
        count+=arr[0]%2==1?1:0;
        count=arr[1]%2==1?count+1:0;
        for(int i =2;i<arr.length;i++)
        {
            if(arr[i]%2==1)
                count++;
            else
                count=0;
            if(count==3)
                return true;
        }
        return false;
    }
}