class Solution {
	public int[] replaceElements(int[] arr) {
		int maxNum = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] < maxNum) {
				arr[i] = maxNum;
			} else {
				int temp = maxNum;
				maxNum = arr[i];
				arr[i] = temp;

			}
		}
		arr[arr.length - 1] = -1;
		return arr;
	}
}