class Solution {
	public int[] singleNumber(int[] nums) {
		int temp = 0;
		for (int num : nums) {
			temp ^= num;
		}
		String string = Integer.toBinaryString(temp);
		int index = 0;
		for (int i = string.length() - 1; i >= 0; i--) {
			if (string.charAt(i) == '1') {
				index = i;
				break;
			}
		}
		int temp1 = 0;
		int temp2 = 0;
		for (int num : nums) {
			try {
				String numString = Integer.toBinaryString(num);
				if (numString.charAt(numString.length() - index - 1) == '0') {
					temp1 ^= num;
				} else {
					temp2 ^= num;
				}
			} catch (Exception e) {
				temp1 ^= num;
			}
		}
		int[] tempint = new int[2];
		tempint[0] = temp1;
		tempint[1] = temp2;
		return tempint;
	}
}