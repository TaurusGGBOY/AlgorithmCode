class Solution {
    public int[] exchange(int[] nums) {
        int ji = 0;
        int ou = nums.length - 1;
        try {
            while (ji < ou) {
                while (nums[ji] % 2 == 1)ji++ ;
                while (nums[ou] % 2 == 0)ou--;
                if(ji>=ou)
                    break;
                int temp = nums[ji];
                nums[ji]=nums[ou];
                nums[ou] = temp;
            }
        } catch (Exception e) {

        }
        return nums;
    }
}