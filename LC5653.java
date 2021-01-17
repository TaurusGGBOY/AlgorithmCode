class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int count = 0;
        int max = 0;
        for (int[] rectangle : rectangles) {
            int temp = Math.min(rectangle[0], rectangle[1]);
            if(temp == max){
                count++;
            }else if(temp > max){
                count  =1;
                max = temp;
            }
        }
        return count;
    }
}