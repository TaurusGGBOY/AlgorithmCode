class Solution {
    public int[] constructArr(int[] a) {
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        int[] res = new int[a.length];
        int temp = 1;
        for (int i = 0; i < a.length; i++) {
            left[i] = temp;
            temp *= a[i];
        }
        temp = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            right[i] = temp;
            temp *= a[i];
        }
        for (int i = 0; i < a.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}