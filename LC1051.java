class Solution {
	public int heightChecker(int[] heights) {
		int[] a = new int[101];
		int count = 0;
		for (int height : heights) {
			a[height]++;
		}

		int j = 0;
		for (int i = 1; i <= a.length - 1; i++) {
			while (a[i]-- > 0) {
				if (heights[j++] != i)
					count++;
			}
		}
		return count;
	}
}