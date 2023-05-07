class Solution {
    public int insertBits(int N, int M, int i, int j) {
        for (int distance = i; distance < j + 1; distance++)
            // 将11111111111111111111111111111110首尾循环移动 distance 位并与 N 与运算将第 distance 位清零
            N = N & Integer.rotateLeft(~1, distance);
        return N | (M << i);
    }
}