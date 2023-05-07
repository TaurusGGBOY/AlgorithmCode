import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> stack = new ArrayList<>();
        int pos = 1;
        for (int i : target) {
            while(pos != i){
                stack.add("Push");
                stack.add("Pop");
                pos++;
            }
            stack.add("Push");
            pos++;
        }
        return stack;
    }
}