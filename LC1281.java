class Solution {
	public int subtractProductAndSum(int n) {
		String nString = String.valueOf(n);
		int len = nString.length();
		int sum = 0;
		int result = 1;
		for (int i = 0; i < len; i++) {
			sum += nString.charAt(i) - '0';
			result *= nString.charAt(i) - '0';
		}
		return result - sum;
	}
}