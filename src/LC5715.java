import java.util.Arrays;

class Solution {
    public int reinitializePermutation(int n) {
        int[] arr = new int[n];
        int[] perm = new int[n];
        for (int i = 0; i < perm.length; i++) {
            perm[i] = i;
        }
        int count = 0;
        int flag = 0;
        while (true) {
            flag = 1;
            count++;
            for (int i = 0; i < perm.length; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                    if (arr[i] != i) {
                        flag = 0;
                    }
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                    if (arr[i] != i) {
                        flag = 0;
                    }
                }
            }
            perm = Arrays.copyOf(arr, perm.length);
            if (flag == 1) {
                break;
            }
        }

        return count;
    }
}