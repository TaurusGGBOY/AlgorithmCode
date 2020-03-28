class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        flood(image, sr, sc, newColor,image[sr][sc]);
        return image;
    }

    void flood(int[][] image, int x, int y, int newColor,int oldColor) {
        if (x >= image.length || x < 0 || y >= image[0].length || y < 0) return;
        if (image[x][y] == newColor || image[x][y] != oldColor) return;
        image[x][y] = newColor;
        flood(image, x + 1, y, newColor,oldColor);
        flood(image, x - 1, y, newColor,oldColor);
        flood(image, x, y + 1, newColor,oldColor);
        flood(image, x, y - 1, newColor,oldColor);
    }
}
