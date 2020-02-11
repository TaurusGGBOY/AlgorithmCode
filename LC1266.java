class Solution {
	public int minTimeToVisitAllPoints(int[][] points) {
		int answer = 0, temp;
		for (int i = 0; i < points.length - 1; i++) {
			temp = Math.max(Math.abs(points[i + 1][0] - points[i][0]), Math.abs(points[i + 1][1] - points[i][1])); // 两点之间横坐标和纵坐标分别相减,再取绝对值,所需要的时间就是其中的最大值,
			answer += temp; // 遍历所有数组叠加时间
		}
		return answer;
	}
}