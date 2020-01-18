class Solution {
	int[] temp;

	public int numTrees(int n) {
		temp = new int[n + 1];
		temp[0] = 1;
		temp[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				temp[i] += temp[j] * temp[i - j - 1];
			}
		}
		return temp[n];
	}

}