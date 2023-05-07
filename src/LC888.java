import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0;
        int sumB = 0;
        int ave = 0;
        Set<Integer> setA = new HashSet<>();
        for(int i:A)
        {
            setA.add(i);
            sumA += i;
        }
        for(int i:B)
            sumB += i;
        ave=(sumA+sumB)/2;
        for(int i:B)
        {
            if(setA.contains(-sumB+ave+i))
                return new int[]{-sumB+ave+i,i};
        }
        return null;
    }
}