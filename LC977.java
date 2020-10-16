import java.util.Arrays;
import java.util.Stack;
//执行结果：
//        通过
//        显示详情
//        执行用时：
//        5 ms
//        , 在所有 Java 提交中击败了
//        11.20%
//        的用户
//        内存消耗：
//        40.9 MB
//        , 在所有 Java 提交中击败了
//        5.28%
//        的用户
//   惊了 这种方法的复杂度是o(n)最少是扫一遍 弹一遍 最多是扫一半 比一半？？？
// 试用直接用sort
//class Solution {
//    public int[] sortedSquares(int[] A) {
//        int[] res = new int[A.length];
//        int resPos = 0;
//        Stack<Integer> stack = new Stack<>();
//        int pos = 0;
//
//        while (pos<A.length&&A[pos] < 0) {
//            stack.add(A[pos] * A[pos]);
//            pos++;
//        }
//        // 考虑如果pos直接=A.length的情况
//        while(pos<A.length)
//        {
//            int temp = A[pos] * A[pos];
//            while (!stack.isEmpty()&&temp>stack.peek())
//            {
//                res[resPos++] = stack.pop();
//            }
//            res[resPos++]=temp;
//            pos++;
//        }
//        while(!stack.isEmpty())
//        {
//            res[resPos++] = stack.pop();
//        }
//        return res;
//    }
//}
//执行用时：
//        4 ms
//        , 在所有 Java 提交中击败了
//        15.68%
//        的用户
//        内存消耗：
//        40.7 MB
//        , 在所有 Java 提交中击败了
//        24.70%
//        的用户
//        炫耀一下:
class Solution {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }
}