import java.util.*;
import java.util.stream.Collectors;

class Solution {
    int[] fib;
    int res;

    public int findMinFibonacciNumbers(int k) {
        getFib(k);
        int res = 0;
        while (k != 0) {
            int index = Arrays.binarySearch(fib, k);
            if (index < 0) index = -index - 1;
            if(fib[index] != k) index--;
            k -= fib[index];
            res++;
        }
        return res;
    }



    private void getFib(int k) {
        int l = 1;
        int r = 1;
        int n = 2;
        List<Integer> list = new ArrayList<>();
        list.add(l);
        while (r <= k) {
            l = r;
            r = n;
            n = l + r;
            list.add(r);
        }
        fib = list.stream().mapToInt(Integer::intValue).toArray();
    }


}