class Solution {
	public int[] singleNumbers(int[] nums) {
		int[] temp = new int[2];
		int temp1=0;
		for(int i=0;i<nums.length;i++)
		{
			temp1^=nums[i];
		}
		String str = Integer.toBinaryString(temp1);
		int index = str.length()-str.indexOf("1");
		String numstr;
		for(int i=0;i<nums.length;i++)
		{
			numstr=Integer.toBinaryString(nums[i]);
			try {
				if(numstr.charAt(numstr.length()-index)=='0')
					temp[0]^=nums[i];
				else
					temp[1]^=nums[i];
			}
			catch (Exception e)
			{
				temp[0]^=nums[i];
			}

		}
		return temp;
	}
}