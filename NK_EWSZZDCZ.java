public class Solution {
    public boolean Find(int target, int[][] array) {
        int[] canBe = new int[array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (target == array[i][j])
                    return true;
            }
        }
        return false;
    }
}