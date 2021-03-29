import java.math.BigInteger;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int numDifferentIntegers(String word) {
        word = word.replaceAll("[^0-9]", " ");
        String[] strs = word.split(" +");
        Set<BigInteger> set = new HashSet<>();
        for (String str : strs) {
            try {
                BigInteger bigInteger = new BigInteger(str);
                set.add(bigInteger);
            } catch (Exception e) {

            }
        }
        return set.size();
    }
}