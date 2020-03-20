class NumArray {
    int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length];
        int temp=0;
        for(int i=0;i<nums.length;i++)
        {
            temp+=nums[i];
            sums[i]=temp;
        }

    }

    public int sumRange(int i, int j) {
        if(i==0)
            return sums[j];
        return sums[j]-sums[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */