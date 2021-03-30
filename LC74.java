class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            int temp = matrix[mid / cols][mid % cols];
            if (temp < target) {
                left = mid + 1;
            } else if (temp > target) {
                right = mid - 1;
            } else {
                break;
            }
            mid = (left + right) / 2;
        }
        return matrix[mid / cols][mid % cols] == target;
    }
}