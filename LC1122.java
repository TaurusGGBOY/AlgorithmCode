class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] oneArray = new int[1001];
        int[] result = new int[arr1.length];
        for(int num:arr1)
            oneArray[num]++;
        int index=0;
        for(int i=0;i<arr2.length;i++)
        {
            int temp =oneArray[arr2[i]];
            for(int j=0;j<temp;j++)
            {
                result[index++]=arr2[i];
                oneArray[arr2[i]]=0;
            }
        }
        for(int i=0;i<1001;i++)
        {
            for(int j=0;j<oneArray[i];j++)
            {
                result[index++]=i;
            }
        }
        return result;
    }
}