class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int answer = 0, temp;
        for (int i = 0; i < points.length - 1; i++) {
            temp = Math.max(Math.abs(points[i + 1][0] - points[i][0]), Math.abs(points[i + 1][1] - points[i][1])); // ����֮��������������ֱ����,��ȡ����ֵ,����Ҫ��ʱ��������е����ֵ,
            answer += temp; // ���������������ʱ��
        }
        return answer;
    }
}