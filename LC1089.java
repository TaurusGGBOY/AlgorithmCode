class Solution {
    public void duplicateZeros(int[] arr) {
        int l = 0;
        while (l < arr.length) {
            if (arr[l] != 0) {
                l++;
                continue;
            }
            for (int i = arr.length - 1; i > l; i--) arr[i] = arr[i - 1];
            try {
                arr[l + 1] = 0;
            } catch (Exception e) {
            }
            l += 2;
        }
    }
}