class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count = 0;
        int min = 0;
        int max = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
            if (min + count != max) {
                count++;
                continue;
            }
            min = max + 1;
            count = 0;
            res++;
        }
        return res;
    }
}