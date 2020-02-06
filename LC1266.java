class Solution {
	public int minTimeToVisitAllPoints(int[][] points) {
		int value = 0;
		for (int i = 0; i < points.length - 1; i++) {
			int x1 = 0;
			int y1 = 0;
			int x2 = 0;
			int y2 = 0;
			if (points[i + 1][0] > points[i][0]) {
				x1 = points[i + 1][0];
				y1 = points[i + 1][1];
				x2 = points[i][0];
				y2 = points[i][1];
			} else {
				x2 = points[i + 1][0];
				y2 = points[i + 1][1];
				x1 = points[i][0];
				y1 = points[i][1];
			}
			value += x1 - x2 + Math.abs(y2 - y1 + x1 - x2);
		}
		return value;
	}
}