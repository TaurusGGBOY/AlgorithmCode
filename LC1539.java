class Solution {
    public int findKthPositive(int[] arr, int k) {
        int res = k;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=res)
            {
                res++;
            }
            else
                return res;
        }
        return res;
    }
}