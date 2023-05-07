import java.lang.reflect.Array;
import java.util.Arrays;
// TODO fail
class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int times = (arr.length + 1) / 2;
        int sum = Arrays.stream(arr).sum();
        return sum * times;
    }
}