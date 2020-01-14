class Solution {
	private int[] intArray;

	public int[] countBits(int num) {
		intArray = new int[num + 1];
		for (int i = 0; i <= num; i++)
			if (i % 2 == 1)
				intArray[i] = intArray[i - 1] + 1;
			else
				intArray[i] = intArray[i / 2];
		return intArray;

	}

}