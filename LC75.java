class Solution {
	public void sortColors(int[] nums) {
		int[] color = new int[3];
		for (int num : nums)
			color[num]++;
		int i = 0;
		while (i < color[0])
			nums[i++] = 0;
		while (i < color[0] + color[1])
			nums[i++] = 1;
		while (i < nums.length)
			nums[i++] = 2;
	}
}